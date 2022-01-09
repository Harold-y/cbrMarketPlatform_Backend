package org.chengbing.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.chengbing.entity.Region;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface RegionMapper extends BaseMapper<Region> {
    IPage<Region> selectPageRegion(Page<Region> page);
    Integer insertRegion(Region region);
    IPage<Region> searchRegion(String searchContent, Page<Region> page);
}
