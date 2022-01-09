package org.chengbing.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.Region;
import org.chengbing.entity.State;
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
@RequestMapping("/state")
public class StateController {
    @Resource
    IStateService service;

    @GetMapping("/queryAllStates")
    public ResultWithInfo<List<Map>> queryAllRegion(Integer page, Integer rowsPerPage)
    {
        Page<Map> pageState = new Page<>(page + 1, rowsPerPage);
        IPage<Map> states = service.selectPageState(pageState);
        Integer totalPage = Math.toIntExact(states.getPages());
        return new ResultWithInfo<>(states.getRecords(), 200, totalPage);
    }

    @PostMapping("addState")
    public boolean addState(State state)
    {
        return service.save(state);
    }

    @DeleteMapping("/deleteStateById")
    public boolean removeState(Integer stateId)
    {
        return service.removeById(stateId);
    }

    @GetMapping("/selectStateById")
    public Result<Map> selectStateById(Integer stateId)
    {
        return new Result<>(service.selectStateById(stateId), 200);
    }

    @PostMapping("/updateStateById")
    public boolean updateStateById(State state)
    {
        return service.updateById(state);
    }

    @GetMapping("/searchState")
    public ResultWithInfo<List<Map>> searchState(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<Map> pageState = new Page<>(page + 1, rowsPerPage);
        IPage<Map> states = service.searchState(searchContent, pageState);
        Integer totalPage = Math.toIntExact(states.getPages());
        return new ResultWithInfo<>(states.getRecords(), 200, totalPage);
    }

    @GetMapping("/selectStateByRegionId")
    public Result<List<State>> selectStateByRegionId(Integer regionId)
    {
        return new Result<>(service.selectStateByRegionId(regionId), 200);
    }

}

