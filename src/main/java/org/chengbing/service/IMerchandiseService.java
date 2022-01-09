package org.chengbing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.Merchandise;
import com.baomidou.mybatisplus.extension.service.IService;
import org.chengbing.util.ResultWithInfo;
import org.chengbing.util.ResultWithStr;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface IMerchandiseService extends IService<Merchandise> {
    IPage<Map> selectPageMerchandise(Page<Map> page);
    Integer insertMerchandise(Merchandise merchandise);
    IPage<Map> searchMerchandise(String searchContent, Page<Map> page);
    Map selectPageMerchandiseById(Integer merchId);

    ResultWithStr<Integer> updateMerchandiseImg(MultipartFile img, Integer merchId);
    Integer inactivateMerchandise(Integer merchId);
    String selectFolder(Integer merchId);
    String selectImageSet(Integer merchId);
    Integer deleteImage(Integer imageId, Integer merchId);

    ResultWithStr<Integer> updateDescriptionImg(MultipartFile[] img, Integer merchId);
    ResultWithStr<Integer> deleteDescriptionImg(Integer merchId);
    Integer updateDescriptionImgNum(Integer num, Integer merchId);

    Integer selectDescriptionImgNum(Integer merchId);
    Integer deleteDescriptionImgNum(Integer merchId);
    String selectDescription(Integer merchId);
    Integer updateDescription(String description, Integer merchId);
    Integer selectUserIdByMerchId(Integer merchId);
    IPage<Map> selectPageMerchandiseSeller(Page<Map> page);
    IPage<Map> searchMerchandiseSeller(String searchContent, Page<Map> page);

    List<Map> selectMainPage();
    List<Map> selectMainPageBySaleAmount();
}
