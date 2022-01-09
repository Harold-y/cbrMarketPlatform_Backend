package org.chengbing.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.chengbing.entity.Region;
import org.chengbing.dao.RegionMapper;
import org.chengbing.service.IRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {
    @Resource
    private RegionMapper mapper;

    @Override
    public IPage<Region> selectUserPage(Page<Region> page) {
        return mapper.selectPageRegion(page);
    }

    @Override
    public Integer insertRegion(Region region) {
        return mapper.insertRegion(region);
    }

    @Override
    public IPage<Region> searchRegion(String searchContent, Page<Region> page) {
        return mapper.searchRegion(searchContent, page);
    }

}
