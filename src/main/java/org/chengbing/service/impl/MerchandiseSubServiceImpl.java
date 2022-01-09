package org.chengbing.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import org.chengbing.dao.MerchandiseMapper;
import org.chengbing.entity.Merchandise;
import org.chengbing.entity.MerchandiseSub;
import org.chengbing.dao.MerchandiseSubMapper;
import org.chengbing.service.IMerchandiseSubService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.chengbing.util.ResultWithStr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@Service
public class MerchandiseSubServiceImpl extends ServiceImpl<MerchandiseSubMapper, MerchandiseSub> implements IMerchandiseSubService {

    @Resource
    MerchandiseSubMapper mapper;
    @Resource
    MerchandiseMapper merchandiseMapper;
    @Value("${file.uploadFolder}")
    String uploadFolder;

    @Override
    public List<MerchandiseSub> selectMerchandiseSub(Integer merchId) {
        return mapper.selectMerchandiseSub(merchId);
    }

    @Override
    public Integer insertMerchandiseSub(MerchandiseSub sub) {
        // 权限认证
        Integer personnelId = merchandiseMapper.selectUserIdByMerchId(sub.getMerchId());
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return -1;
        sub.setMerchSubStatus(1);
        sub.setMerchSubCreateDate(LocalDateTime.now());
        BigDecimal price = sub.getMerchSubPrice();
        if(price.doubleValue() < 0.00)
            return -1;
        return mapper.insertMerchandiseSub(sub);
    }

    @Override
    public MerchandiseSub selectById(Integer merchSubId) {
        return mapper.selectById(merchSubId);
    }

    @Override
    public Integer updateMerchandiseSub(MerchandiseSub sub) {
        // 权限认证
        Integer personnelId =selectPersonnelToAuth(sub.getMerchSubId());
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return -1;
        if(sub.getMerchSubPrice().doubleValue() < 0.00)
            return -1;
        if(sub.getMerchSubOnsalePrice() != null && sub.getMerchSubOnsalePrice().doubleValue() < 0.00)
            return -1;
        return mapper.updateMerchandiseSub(sub);
    }

    @Override
    public Integer inactivateSub(Integer merchSubId) {
        // 权限认证
        Integer personnelId =selectPersonnelToAuth(merchSubId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return -1;
        return mapper.inactivateSub(merchSubId);
    }

    @Override
    public Integer reactivateSub(Integer merchSubId) {
        // 权限认证
        Integer personnelId =selectPersonnelToAuth(merchSubId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return -1;
        return mapper.reactivateSub(merchSubId);
    }

    @Override
    public Integer selectPersonnelToAuth(Integer merchSubId) {
        return mapper.selectPersonnelToAuth(merchSubId);
    }

    @Override
    public Integer deleteImage(Integer merchSubId) {
        // 权限认证
        Integer personnelId =selectPersonnelToAuth(merchSubId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return -1;
        MerchandiseSub sub = selectById(merchSubId);
        String photoUrl = sub.getMerchSubPhotoUrl();
        Merchandise merchandise = merchandiseMapper.selectById(sub.getMerchId());
        String pathName = merchandise.getMerchPhotoFolder();
        String filePath = uploadFolder + "/merchandise/" + pathName;

        File dest = new File(filePath+"/"+ photoUrl);
        if(!dest.exists())
            return -1;
        boolean res = dest.delete();
        updatePhotoUrl("", merchSubId);
        return res ? 1 : -1;
    }

    @Override
    public Integer updateImage(MultipartFile img, Integer merchSubId) {
        // 权限认证
        Integer personnelId =selectPersonnelToAuth(merchSubId);
        if(personnelId != Integer.parseInt((String) StpUtil.getLoginId()))
            return -1;
        String photoUrl = UUID.randomUUID() + ".jpg";
        MerchandiseSub sub = selectById(merchSubId);
        Merchandise merchandise = merchandiseMapper.selectById(sub.getMerchId());
        String pathName = merchandise.getMerchPhotoFolder();
        String filePath = uploadFolder + "/merchandise/" + pathName;
        File dest = new File(filePath);
        if(!dest.exists())
            dest.mkdirs();
        try {
            img.transferTo(new File(filePath, photoUrl));
            updatePhotoUrl(photoUrl, merchSubId);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    @Override
    public String selectUrl(Integer merchSubId) {
        return mapper.selectUrl(merchSubId);
    }

    @Override
    public Integer updatePhotoUrl(String merchSubPhotoUrl, Integer merchSubId) {
        return mapper.updatePhotoUrl(merchSubPhotoUrl, merchSubId);
    }
}
