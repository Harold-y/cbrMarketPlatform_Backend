package org.chengbing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.chengbing.entity.Region;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface IRegionService extends IService<Region> {
    public IPage<Region> selectUserPage(Page<Region> page);
    Integer insertRegion(Region region);
    IPage<Region> searchRegion(String searchContent, Page<Region> page);
}
