package org.chengbing.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.City;
import org.chengbing.dao.CityMapper;
import org.chengbing.service.ICityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {

    @Resource
    CityMapper mapper;

    @Override
    public IPage<Map> selectPageCity(Page<Map> page) {
        return mapper.selectPageCity(page);
    }

    @Override
    public Map selectCityById(Integer cityId) {
        return mapper.selectCityById(cityId);
    }

    @Override
    public IPage<Map> searchCity(String searchContent, Page<Map> page) {
        return mapper.searchCity(searchContent, page);
    }
}
