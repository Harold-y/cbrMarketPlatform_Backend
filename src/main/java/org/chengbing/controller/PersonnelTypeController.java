package org.chengbing.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.PersonnelAuth;
import org.chengbing.entity.PersonnelType;
import org.chengbing.entity.Region;
import org.chengbing.service.IPersonnelTypeService;
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
@RequestMapping("/personnelType")
public class PersonnelTypeController {
    @Resource
    IPersonnelTypeService service;

    @GetMapping("/queryAllPersonnelType")
    public ResultWithInfo<List<PersonnelType>> queryAllPersonnelType(Integer page, Integer rowsPerPage)
    {
        Page<PersonnelType> pagePersonnelType = new Page<>(page + 1, rowsPerPage);
        IPage<PersonnelType> personnelTypes = service.selectPagePersonnelType(pagePersonnelType);
        Integer totalPage = Math.toIntExact(personnelTypes.getPages());
        return new ResultWithInfo<>(personnelTypes.getRecords(), 200, totalPage);
    }

    @GetMapping("queryAllPersonnelTypeAll")
    public Result<List<PersonnelType>> queryAllPersonnelTypeAll()
    {
        return new Result<>(service.list(), 200);
    }

    @PostMapping("/addNewPersonnelType")
    public Integer addNewPersonnelType(PersonnelType personnelType)
    {
        return service.insertPersonnelType(personnelType);
    }

    @DeleteMapping("/removePersonnelTypeById")
    public boolean removePersonnelTypeById(Integer personnelTypeId)
    {
        return service.removeById(personnelTypeId);
    }

    @GetMapping("/getPersonnelTypeById")
    public Result<PersonnelType> getPersonnelTypeById(Integer personnelTypeId)
    {
        return new Result<>(service.getById(personnelTypeId), 200);
    }

    @GetMapping("/searchPersonnelType")
    public ResultWithInfo<List<PersonnelType>> searchPersonnelType(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<PersonnelType> pagePersonnelType = new Page<>(page + 1, rowsPerPage);
        IPage<PersonnelType> personnelTypes = service.searchPersonnelType(searchContent, pagePersonnelType);
        Integer totalPage = Math.toIntExact(personnelTypes.getPages());
        return new ResultWithInfo<>(personnelTypes.getRecords(), 200, totalPage);
    }

    @PostMapping("/editPersonnelTypeById")
    public boolean editPersonnelTypeById(PersonnelType personnelType)
    {
        return service.updateById(personnelType);
    }

    @GetMapping("/selectAuthByPersonnelTypeId")
    public Result<List<Map>> selectAuthByPersonnelTypeId(Integer personnelTypeId) {
        return new Result<>(service.selectAuthByPersonnelTypeId(personnelTypeId), 200);
    }

    @PostMapping("/insertPersonnelAuth")
    public Integer insertPersonnelAuth(PersonnelAuth auth) {
        return service.insertPersonnelAuth(auth);
    }

    @DeleteMapping("/deletePersonnelAuth")
    public Integer deletePersonnelAuth(Integer authId, Integer personnelTypeId) {
        return service.deletePersonnelAuth(authId, personnelTypeId);
    }
}

