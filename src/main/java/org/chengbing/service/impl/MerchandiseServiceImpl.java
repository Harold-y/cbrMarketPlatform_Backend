package org.chengbing.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.Merchandise;
import org.chengbing.dao.MerchandiseMapper;
import org.chengbing.service.IMerchandiseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.chengbing.util.ResultWithInfo;
import org.chengbing.util.ResultWithStr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@Service
public class MerchandiseServiceImpl extends ServiceImpl<MerchandiseMapper, Merchandise> implements IMerchandiseService {

    @Resource
    MerchandiseMapper mapper;
    @Value("${file.uploadFolder}")
    String uploadFolder;
    @Override
    public IPage<Map> selectPageMerchandise(Page<Map> page) {
        return mapper.selectPageMerchandise(page);
    }

    @Override
    public Integer insertMerchandise(Merchandise merchandise) {
        String name = merchandise.getMerchName();
        String UUID = java.util.UUID.randomUUID().toString();
        merchandise.setMerchStatus(1);
        merchandise.setMerchCreateDate(LocalDateTime.now());
        merchandise.setMerchSpecial(0);
        merchandise.setMerchPhotoFolder(name+"_"+UUID);
        merchandise.setPersonnelId(Integer.parseInt((String) StpUtil.getLoginId()));
        return mapper.insertMerchandise(merchandise);
    }

    @Override
    public IPage<Map> searchMerchandise(String searchContent, Page<Map> page) {
        return mapper.searchMerchandise(searchContent, page);
    }

    @Override
    public Map selectPageMerchandiseById(Integer merchId) {
        return mapper.selectPageMerchandiseById(merchId);
    }

    @Override
    public ResultWithStr<Integer> updateMerchandiseImg(MultipartFile img, Integer merchId){
        try {
            String imageSet = mapper.selectImageSet(merchId);
            if(imageSet == null || imageSet.equals(""))
                imageSet = "-";
            List<String> imageSelectionSet = Arrays.asList(imageSet.split("-"));
            if (imageSelectionSet.size() >= 6)
                return new ResultWithStr<>(-1,406, "Frontend Image Filter Failed. Max Number Limit Reached.");
            List<Integer> convertSelectionSet = new ArrayList<>();
            for (String s : imageSelectionSet)
                convertSelectionSet.add(Integer.parseInt(s));
            int toAdd = 1;
            for(;toAdd<6;toAdd++)
            {
                if(!convertSelectionSet.contains(toAdd))
                    break;
            }
            convertSelectionSet.add(toAdd);
            String toUpdate = "";
            for(Integer i: convertSelectionSet)
                toUpdate += i + "-";
            Merchandise merchandise = mapper.selectById(merchId);
            String pathName = merchandise.getMerchPhotoFolder();
            String filePath = uploadFolder + "/merchandise/" + pathName;
            File dest = new File(filePath);
            if(!dest.exists()){
                dest.mkdirs();
            }
            img.transferTo(new File(filePath, toAdd+".jpg"));
            mapper.updatePhotoSet(toUpdate, merchId);
        } catch (Exception e)
        {
            return new ResultWithStr<>(-1,406, e.getMessage());
        }
        return new ResultWithStr<>(1, 200, "Success");
    }



    @Override
    public Integer deleteImage(Integer imageId, Integer merchId) {
        String imageSet = mapper.selectImageSet(merchId);
        List<String> imageSelectionSet = Arrays.asList(imageSet.split("-"));
        List<Integer> convertSelectionSet = new ArrayList<>();
        for (String s : imageSelectionSet)
            convertSelectionSet.add(Integer.parseInt(s));
        boolean isRemove = convertSelectionSet.remove(imageId);
        Merchandise merchandise = mapper.selectById(merchId);
        String pathName = merchandise.getMerchPhotoFolder();
        String filePath = uploadFolder + "/merchandise/" + pathName;
        File dest = new File(filePath+"/"+imageId+".jpg");
        if(!dest.exists())
            return -1;
        boolean res = dest.delete();
        String toUpdate = "";
        for(Integer i: convertSelectionSet)
            toUpdate += i + "-";
        mapper.updatePhotoSet(toUpdate, merchId);
        return res ? 1 : -1;
    }

    @Override
    public Integer inactivateMerchandise(Integer merchId) {
        return mapper.inactivateMerchandise(merchId);
    }

    @Override
    public String selectFolder(Integer merchId) {
        return mapper.selectFolder(merchId);
    }

    @Override
    public String selectImageSet(Integer merchId) {
        return mapper.selectImageSet(merchId);
    }

    @Override
    public ResultWithStr<Integer> updateDescriptionImg(MultipartFile[] img, Integer merchId)
    {
        Merchandise merchandise = mapper.selectById(merchId);
        String pathName = merchandise.getMerchPhotoFolder();
        String filePath = uploadFolder + "/merchandise/" + pathName;
        File dest = new File(filePath);
        if(!dest.exists()){
            dest.mkdirs();
        }
        try {
            for(int i =1;i <= img.length; i ++)
            {
                img[i-1].transferTo(new File(filePath, "description"+i+".jpg"));
            }
            updateDescriptionImgNum(img.length, merchId);
            return new ResultWithStr<>(1, 200, "Success");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultWithStr<>(-1,406, e.getMessage());
        }
    }

    @Override
    public ResultWithStr<Integer> deleteDescriptionImg(Integer merchId)
    {
        Merchandise merchandise = mapper.selectById(merchId);
        String pathName = merchandise.getMerchPhotoFolder();
        String filePath = uploadFolder + "/merchandise/" + pathName;
        int totalNum = selectDescriptionImgNum(merchId);
        for(int i = 1 ; i <= totalNum; i ++)
        {
            File dest = new File(filePath+"/description"+i+".jpg");
            if(!dest.exists())
                return new ResultWithStr<>(-1, 406);
            boolean res = dest.delete();
        }
        deleteDescriptionImgNum(merchId);
        return new ResultWithStr<>(1, 200, "Success");
    }

    @Override
    public Integer updateDescriptionImgNum(Integer num, Integer merchId)
    {
        return mapper.updateDescriptionImgNum(num, merchId);
    }

    @Override
    public Integer selectDescriptionImgNum(Integer merchId)
    {
        return mapper.selectDescriptionImgNum(merchId);
    }

    @Override
    public Integer deleteDescriptionImgNum(Integer merchId)
    {
        return mapper.deleteDescriptionImgNum(merchId);
    }

    @Override
    public String selectDescription(Integer merchId)
    {
        return mapper.selectDescription(merchId);
    }

    @Override
    public Integer updateDescription(String description, Integer merchId)
    {
        return mapper.updateDescription(description, merchId);
    }

    @Override
    public Integer selectUserIdByMerchId(Integer merchId)
    {
        return mapper.selectUserIdByMerchId(merchId);
    }

    @Override
    public IPage<Map> selectPageMerchandiseSeller(Page<Map> page)
    {
        return mapper.selectPageMerchandiseSeller(page, Integer.parseInt((String) StpUtil.getLoginId()));
    }

    @Override
    public IPage<Map> searchMerchandiseSeller(String searchContent, Page<Map> page) {
        return mapper.searchMerchandiseSeller(searchContent, page, Integer.parseInt((String) StpUtil.getLoginId()));
    }

    @Override
    public List<Map> selectMainPage() {
        List<Map> list = mapper.selectMainPage();
        for(Map map : list)
        {
            String merchPhotoSet = (String) map.get("merch_photo_set");
            if(merchPhotoSet == null || merchPhotoSet.equals(""))
                merchPhotoSet = "-";
            List<String> imageSelectionSet = Arrays.asList(merchPhotoSet.split("-"));
            map.put("merch_photo_set", imageSelectionSet.get(0));
        }
        return list;
    }

    @Override
    public List<Map> selectMainPageBySaleAmount() {
        List<Map> list = mapper.selectMainPageBySaleAmount();
        for(Map map : list)
        {
            Integer merchId = (Integer) map.get("merch_id");
            Double minPrice = mapper.selectMinPrice(merchId);
            if(minPrice == null)
                minPrice = 0.00;
            map.put("minprice", minPrice);
            String merchPhotoSet = (String) map.get("merch_photo_set");
            if(merchPhotoSet == null || merchPhotoSet.equals(""))
                merchPhotoSet = "-";
            List<String> imageSelectionSet = Arrays.asList(merchPhotoSet.split("-"));
            map.put("merch_photo_set", imageSelectionSet.get(0));
        }
        return list;
    }


}
