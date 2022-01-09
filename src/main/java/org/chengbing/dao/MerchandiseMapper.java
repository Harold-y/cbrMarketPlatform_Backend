package org.chengbing.dao;

import org.chengbing.entity.Merchandise;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface MerchandiseMapper extends BaseMapper<Merchandise> {
    IPage<Map> selectPageMerchandise(Page<Map> page);
    Integer insertMerchandise(Merchandise merchandise);
    IPage<Map> searchMerchandise(String searchContent, Page<Map> page);
    Map selectPageMerchandiseById(Integer merchId);
    Integer inactivateMerchandise(Integer merchId);
    String selectFolder(Integer merchId);
    String selectImageSet(Integer merchId);
    Integer updatePhotoSet(String merchPhotoSet, Integer merchId);

    Integer selectDescriptionImgNum(Integer merchId);
    Integer deleteDescriptionImgNum(Integer merchId);
    Integer updateDescriptionImgNum(Integer num, Integer merchId);
    String selectDescription(Integer merchId);
    Integer updateDescription(String description, Integer merchId);
    Integer selectUserIdByMerchId(Integer merchId);
    IPage<Map> selectPageMerchandiseSeller(Page<Map> page, Integer personnelId);
    IPage<Map> searchMerchandiseSeller(String searchContent, Page<Map> page, Integer personnelId);

    List<Map> selectMainPage();
    List<Map> selectMainPageBySaleAmount();
    Double selectMinPrice(Integer merchId);
}
