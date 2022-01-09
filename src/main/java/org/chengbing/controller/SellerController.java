package org.chengbing.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.Merchandise;
import org.chengbing.entity.MerchandiseSub;
import org.chengbing.entity.MerchandiseType;
import org.chengbing.service.IMerchandiseService;
import org.chengbing.service.IMerchandiseSubService;
import org.chengbing.service.IMerchandiseTypeService;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithInfo;
import org.chengbing.util.ResultWithStr;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Resource
    IMerchandiseService service;
    @Resource
    IMerchandiseTypeService merchandiseTypeService;
    @Resource
    IMerchandiseSubService merchandiseSubService;

    @GetMapping("/queryAllMerchandise")
    public ResultWithInfo<List<Map>> queryAllMerchandise(Integer page, Integer rowsPerPage)
    {
        Page<Map> pageMerchandise = new Page<>(page + 1, rowsPerPage);
        IPage<Map> merchandises = service.selectPageMerchandiseSeller(pageMerchandise);
        Integer totalPage = Math.toIntExact(merchandises.getPages());
        return new ResultWithInfo<>(merchandises.getRecords(), 200, totalPage);
    }

    @PostMapping("/addNewMerchandise")
    public Integer addNewMerchandise(Merchandise merchandise)
    {
        return service.insertMerchandise(merchandise);
    }

    @DeleteMapping("/inactivateMerchandise")
    public Integer inactivateMerchandise(Integer merchandiseId)
    {
        // 权限验证
        Integer personnelId = service.selectUserIdByMerchId(merchandiseId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return -1;
        return service.inactivateMerchandise(merchandiseId);
    }

    @GetMapping("/getMerchandiseById")
    public Result<Map> getMerchandiseById(Integer merchandiseId)
    {
        // 权限验证
        Integer personnelId = service.selectUserIdByMerchId(merchandiseId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return null;
        Map res = service.selectPageMerchandiseById(merchandiseId);
        res.remove("merch_special");
        res.remove("merch_photo_folder");
        res.remove("merch_id");
        res.remove("merch_create_date");
        return new Result<>(res, 200);
    }

    @GetMapping("/searchMerchandise")
    public ResultWithInfo<List<Map>> searchMerchandise(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<Map> pageMerchandise = new Page<>(page + 1, rowsPerPage);
        IPage<Map> merchandises = service.searchMerchandiseSeller(searchContent, pageMerchandise);
        Integer totalPage = Math.toIntExact(merchandises.getPages());
        return new ResultWithInfo<>(merchandises.getRecords(), 200, totalPage);
    }

    @PostMapping("/editMerchandiseById")
    public boolean editMerchandiseById(Merchandise merchandise)
    {
        // 权限验证

        Integer personnelId = service.selectUserIdByMerchId(merchandise.getMerchId());
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return false;
        return service.updateById(merchandise);
    }

    @PostMapping("/updateMerchandiseImg")
    public void updateMerchandiseImg(MultipartFile img, Integer merchId){
        // 权限验证
        Integer personnelId = service.selectUserIdByMerchId(merchId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return ;
        service.updateMerchandiseImg(img, merchId);
    }
    @DeleteMapping("/removeImage")
    public Integer deleteImage(Integer imageId, Integer merchId)
    {
        // 权限验证
        Integer personnelId = service.selectUserIdByMerchId(merchId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return -1;
        return service.deleteImage(imageId, merchId);
    }

    @GetMapping("/getImageFolder")
    public String selectFolder(Integer merchId) {
        return service.selectFolder(merchId);
    }

    @GetMapping("/getImageSet")
    public List<String> selectImageSet(Integer merchId)
    {
        String set = service.selectImageSet(merchId);
        if(set == null || set.equals(""))
            return new ArrayList<>();
        String[] disassembly = set.split("-");
        return Arrays.asList(disassembly);
    }

    @GetMapping("/selectDescription")
    public String selectDescription(Integer merchId)
    {
        return service.selectDescription(merchId);
    }

    @PostMapping("/updateDescription")
    public Integer updateDescription(String description, Integer merchId)
    {
        // 权限验证
        Integer personnelId = service.selectUserIdByMerchId(merchId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return -1;
        return service.updateDescription(description, merchId);
    }
    @PostMapping("/updateDescriptionImg")
    public ResultWithStr<Integer> updateDescriptionImg(MultipartFile[] img, Integer merchId)
    {
        // 权限验证
        Integer personnelId = service.selectUserIdByMerchId(merchId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return null;
        return service.updateDescriptionImg(img, merchId);
    }
    @DeleteMapping("/deleteDescriptionImg")
    public ResultWithStr<Integer> deleteDescriptionImg(Integer merchId)
    {
        // 权限验证
        Integer personnelId = service.selectUserIdByMerchId(merchId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return null;
        return service.deleteDescriptionImg(merchId);
    }
    @GetMapping("/selectDescriptionImgNum")
    public Integer selectDescriptionImgNum(Integer merchId)
    {
        return service.selectDescriptionImgNum(merchId);
    }

    @GetMapping("/queryAllMerchandiseTypeAll")
    public Result<List<MerchandiseType>> queryAllMerchandiseTypeAll()
    {
        return new Result<>(merchandiseTypeService.list(), 200);
    }
    // These are for subs
    @GetMapping("/selectMerchandiseSub")
    public Result<List<MerchandiseSub>> selectMerchandiseSub(Integer merchId)
    {
        return new Result<>(merchandiseSubService.selectMerchandiseSub(merchId), 200);
    }
    @PostMapping("/insertMerchandiseSub")
    public Result<Integer> insertMerchandiseSub(MerchandiseSub sub)
    {
        return new Result<>(merchandiseSubService.insertMerchandiseSub(sub), 200);
    }
    @GetMapping("/selectSubById")
    public Result<MerchandiseSub> selectById(Integer merchSubId)
    {
        return new Result<>(merchandiseSubService.selectById(merchSubId), 200);
    }
    @PostMapping("/updateMerchandiseSub")
    public Integer updateMerchandiseSub(MerchandiseSub sub, String promotionDate)
    {
        if(!(promotionDate == null) && !promotionDate.equals(""))
        {
            LocalDateTime time = LocalDateTime.now();
            time = time.plusDays(Integer.parseInt(promotionDate));
            sub.setMerchSubOnsaleEndDate(time);
        }
        return merchandiseSubService.updateMerchandiseSub(sub);
    }
    @PostMapping("/inactivateSub")
    public Integer inactivateSub(Integer merchSubId)
    {
        return merchandiseSubService.inactivateSub(merchSubId);
    }
    @PostMapping("/reactivateSub")
    public Integer reactivateSub(Integer merchSubId)
    {
        return merchandiseSubService.reactivateSub(merchSubId);
    }
    @DeleteMapping("/deleteSubImage")
    public Integer deleteImage(Integer merchSubId)
    {
        return merchandiseSubService.deleteImage(merchSubId);
    }
    @PostMapping("/updateSubImage")
    public Integer updateImage(MultipartFile img, Integer merchSubId)
    {
        return merchandiseSubService.updateImage(img, merchSubId);
    }
    @GetMapping("/selectSubImageUrl")
    public String selectUrl(Integer merchSubId)
    {
        return merchandiseSubService.selectUrl(merchSubId);
    }

}
