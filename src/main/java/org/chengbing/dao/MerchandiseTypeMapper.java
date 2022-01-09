package org.chengbing.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.MerchandiseType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface MerchandiseTypeMapper extends BaseMapper<MerchandiseType> {
    IPage<Map> selectPageMerchandiseType(Page<Map> page);
    Integer insertMerchandiseType(MerchandiseType merchandiseType);
    IPage<Map> searchMerchandiseType(String searchContent, Page<Map> page);
    Map selectPageMerchandiseTypeById(Integer merchTypeId);
}
