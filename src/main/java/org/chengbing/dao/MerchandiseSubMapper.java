package org.chengbing.dao;

import org.chengbing.entity.MerchandiseSub;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface MerchandiseSubMapper extends BaseMapper<MerchandiseSub> {
    List<MerchandiseSub> selectMerchandiseSub(Integer merchId);
    Integer insertMerchandiseSub(MerchandiseSub sub);
    MerchandiseSub selectById(Integer merchSubId);
    Integer updateMerchandiseSub(MerchandiseSub sub);
    Integer inactivateSub(Integer merchSubId);
    Integer reactivateSub(Integer merchSubId);
    Integer selectPersonnelToAuth(Integer merchSubId);
    String selectUrl(Integer merchSubId);
    Integer updatePhotoUrl(String merchSubPhotoUrl, Integer merchSubId);
}
