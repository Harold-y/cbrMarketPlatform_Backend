package org.chengbing.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.City;
import org.chengbing.entity.State;
import org.chengbing.service.ICityService;
import org.chengbing.service.IStateService;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@RestController
@RequestMapping("/city")
public class CityController {
    @Resource
    ICityService service;

    @GetMapping("/queryAllCity")
    public ResultWithInfo<List<Map>> queryAllRegion(Integer page, Integer rowsPerPage)
    {
        Page<Map> pageState = new Page<>(page + 1, rowsPerPage);
        IPage<Map> states = service.selectPageCity(pageState);
        Integer totalPage = Math.toIntExact(states.getPages());
        return new ResultWithInfo<>(states.getRecords(), 200, totalPage);
    }

    @PostMapping("addCity")
    public boolean addState(City city)
    {
        return service.save(city);
    }

    @DeleteMapping("/deleteCityById")
    public boolean removeState(Integer cityId)
    {
        return service.removeById(cityId);
    }

    @GetMapping("/selectCityById")
    public Result<Map> selectStateById(Integer cityId)
    {
        return new Result<>(service.selectCityById(cityId), 200);
    }

    @PostMapping("/updateCityById")
    public boolean updateStateById(City city)
    {
        return service.updateById(city);
    }

    @GetMapping("/searchCity")
    public ResultWithInfo<List<Map>> searchState(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<Map> pageState = new Page<>(page + 1, rowsPerPage);
        IPage<Map> states = service.searchCity(searchContent, pageState);
        Integer totalPage = Math.toIntExact(states.getPages());
        return new ResultWithInfo<>(states.getRecords(), 200, totalPage);
    }
}

