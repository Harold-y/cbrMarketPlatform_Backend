package org.chengbing.controller;


import org.chengbing.entity.MerchandisePropertyType;
import org.chengbing.service.IMerchandisePropertyTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/merchandisePropertyType")
public class MerchandisePropertyTypeController {
    @Resource
    IMerchandisePropertyTypeService service;

    @GetMapping("/queryAllMerchandisePropertyType")
    public ResultWithInfo<List<Map>> queryAllMerchandisePropertyType(Integer page, Integer rowsPerPage)
    {
        Page<Map> pageMerchandisePropertyType = new Page<>(page + 1, rowsPerPage);
        IPage<Map> merchandisePropertyTypes = service.selectPageMerchandisePropertyType(pageMerchandisePropertyType);
        Integer totalPage = Math.toIntExact(merchandisePropertyTypes.getPages());
        return new ResultWithInfo<>(merchandisePropertyTypes.getRecords(), 200, totalPage);
    }

    @GetMapping("queryAllMerchandisePropertyTypeAll")
    public Result<List<MerchandisePropertyType>> queryAllMerchandisePropertyTypeAll()
    {
        return new Result<>(service.list(), 200);
    }

    @PostMapping("/addNewMerchandisePropertyType")
    public Integer addNewMerchandisePropertyType(MerchandisePropertyType merchandisePropertyType)
    {
        return service.insertMerchandisePropertyType(merchandisePropertyType);
    }

    @DeleteMapping("/removeMerchandisePropertyType")
    public boolean removeMerchandisePropertyTypeById(Integer merchandisePropertyTypeId)
    {
        return service.removeById(merchandisePropertyTypeId);
    }

    @GetMapping("/getMerchandisePropertyTypeById")
    public Result<Map> getMerchandisePropertyTypeById(Integer merchandisePropertyTypeId)
    {
        return new Result<>(service.selectPageMerchandisePropertyTypeById(merchandisePropertyTypeId), 200);
    }

    @GetMapping("/searchMerchandisePropertyType")
    public ResultWithInfo<List<Map>> searchMerchandisePropertyType(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<Map> pageMerchandisePropertyType = new Page<>(page + 1, rowsPerPage);
        IPage<Map> merchandisePropertyTypes = service.searchMerchandisePropertyType(searchContent, pageMerchandisePropertyType);
        Integer totalPage = Math.toIntExact(merchandisePropertyTypes.getPages());
        return new ResultWithInfo<>(merchandisePropertyTypes.getRecords(), 200, totalPage);
    }

    @PostMapping("/editMerchandisePropertyTypeById")
    public boolean editMerchandisePropertyTypeById(MerchandisePropertyType merchandisePropertyType)
    {
        return service.updateById(merchandisePropertyType);
    }
}

