package org.chengbing.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.chengbing.entity.Region;
import org.chengbing.service.IRegionService;
import org.chengbing.util.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.util.ResultWithInfo;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@RestController
@RequestMapping("/region")
public class RegionController {

    @Resource
    IRegionService service;

    @GetMapping("/queryAllRegion")
    public ResultWithInfo<List<Region>> queryAllRegion(Integer page, Integer rowsPerPage)
    {
        Page<Region> pageRegion = new Page<>(page + 1, rowsPerPage);
        IPage<Region> regions = service.selectUserPage(pageRegion);
        Integer totalPage = Math.toIntExact(regions.getPages());
        return new ResultWithInfo<>(regions.getRecords(), 200, totalPage);
    }

    @GetMapping("queryAllRegionAll")
    public Result<List<Region>> queryAllRegionAll()
    {
        return new Result<>(service.list(), 200);
    }

    @PostMapping("/addNewRegion")
    public Integer addNewRegion(Region region)
    {
        return service.insertRegion(region);
    }

    @DeleteMapping("/removeRegion")
    public boolean removeRegionById(Integer regionId)
    {
        return service.removeById(regionId);
    }

    @GetMapping("/getRegionById")
    public Result<Region> getRegionById(Integer regionId)
    {
        return new Result<>(service.getById(regionId), 200);
    }

    @GetMapping("/searchRegion")
    public ResultWithInfo<List<Region>> searchRegion(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<Region> pageRegion = new Page<>(page + 1, rowsPerPage);
        IPage<Region> regions = service.searchRegion(searchContent, pageRegion);
        Integer totalPage = Math.toIntExact(regions.getPages());
        return new ResultWithInfo<>(regions.getRecords(), 200, totalPage);
    }

    @PostMapping("/editRegionById")
    public boolean editRegionById(Region region)
    {
        return service.updateById(region);
    }
}

