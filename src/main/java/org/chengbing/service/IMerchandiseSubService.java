package org.chengbing.service;

import org.chengbing.entity.MerchandiseSub;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface IMerchandiseSubService extends IService<MerchandiseSub> {
    List<MerchandiseSub> selectMerchandiseSub(Integer merchId);
    Integer insertMerchandiseSub(MerchandiseSub sub);
    MerchandiseSub selectById(Integer merchSubId);
    Integer updateMerchandiseSub(MerchandiseSub sub);
    Integer inactivateSub(Integer merchSubId);
    Integer reactivateSub(Integer merchSubId);
    Integer selectPersonnelToAuth(Integer merchSubId);

    Integer deleteImage(Integer merchSubId);
    Integer updateImage(MultipartFile img, Integer merchSubId);
    String selectUrl(Integer merchSubId);
    Integer updatePhotoUrl(String merchSubPhotoUrl, Integer merchSubId);
}
