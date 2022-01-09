package org.chengbing.controller;



import org.chengbing.entity.MerchandiseType;
import org.chengbing.service.IMerchandiseTypeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithInfo;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@RestController
@RequestMapping("/merchandiseType")
public class MerchandiseTypeController {
    @Resource
    IMerchandiseTypeService service;

    @GetMapping("/queryAllMerchandiseType")
    public ResultWithInfo<List<Map>> queryAllMerchandiseType(Integer page, Integer rowsPerPage)
    {
        Page<Map> pageMerchandiseType = new Page<>(page + 1, rowsPerPage);
        IPage<Map> merchandiseTypes = service.selectPageMerchandiseType(pageMerchandiseType);
        Integer totalPage = Math.toIntExact(merchandiseTypes.getPages());
        return new ResultWithInfo<>(merchandiseTypes.getRecords(), 200, totalPage);
    }

    @GetMapping("queryAllMerchandiseTypeAll")
    public Result<List<MerchandiseType>> queryAllMerchandiseTypeAll()
    {
        return new Result<>(service.list(), 200);
    }

    @PostMapping("/addNewMerchandiseType")
    public Integer addNewMerchandiseType(MerchandiseType merchandiseType)
    {
        return service.insertMerchandiseType(merchandiseType);
    }

    @DeleteMapping("/removeMerchandiseType")
    public boolean removeMerchandiseTypeById(Integer merchandiseTypeId)
    {
        return service.removeById(merchandiseTypeId);
    }

    @GetMapping("/getMerchandiseTypeById")
    public Result<Map> getMerchandiseTypeById(Integer merchandiseTypeId)
    {
        return new Result<>(service.selectPageMerchandiseTypeById(merchandiseTypeId), 200);
    }

    @GetMapping("/searchMerchandiseType")
    public ResultWithInfo<List<Map>> searchMerchandiseType(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<Map> pageMerchandiseType = new Page<>(page + 1, rowsPerPage);
        IPage<Map> merchandiseTypes = service.searchMerchandiseType(searchContent, pageMerchandiseType);
        Integer totalPage = Math.toIntExact(merchandiseTypes.getPages());
        return new ResultWithInfo<>(merchandiseTypes.getRecords(), 200, totalPage);
    }

    @PostMapping("/editMerchandiseTypeById")
    public boolean editMerchandiseTypeById(MerchandiseType merchandiseType)
    {
        System.out.println(merchandiseType);
        return service.updateById(merchandiseType);
    }
}

