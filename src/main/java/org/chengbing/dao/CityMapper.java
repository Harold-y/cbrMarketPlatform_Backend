package org.chengbing.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.City;
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
public interface CityMapper extends BaseMapper<City> {
    IPage<Map> selectPageCity(Page<Map> page);
    Map selectCityById(Integer cityId);
    IPage<Map> searchCity(String searchContent, Page<Map> page);
}
