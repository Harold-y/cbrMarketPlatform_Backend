package org.chengbing.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.Personnel;
import org.chengbing.service.IPersonnelService;
import org.chengbing.service.IPersonnelTypeService;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithInfo;
import org.chengbing.util.ResultWithStr;
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
@RequestMapping("/personnel")
public class PersonnelController {
    @Resource
    IPersonnelService service;
    @Resource
    IPersonnelTypeService personnelTypeService;

    @GetMapping("/queryAllPersonnel")
    public ResultWithInfo<List<Personnel>> queryAllPersonnel(Integer page, Integer rowsPerPage)
    {
        Page<Personnel> pagePersonnel = new Page<>(page + 1, rowsPerPage);
        IPage<Personnel> personnels = service.selectPagePersonnel(pagePersonnel);
        Integer totalPage = Math.toIntExact(personnels.getPages());
        return new ResultWithInfo<>(personnels.getRecords(), 200, totalPage);
    }

    @PostMapping("/addNewPersonnel")
    public Integer addNewPersonnel(Personnel personnel)
    {
        return service.insertPersonnel(personnel);
    }

    @DeleteMapping("/removePersonnelById")
    public boolean removePersonnelById(Integer personnelId)
    {
        return service.removeById(personnelId);
    }

    @GetMapping("/getPersonnelById")
    public ResultWithStr<Personnel> getPersonnelById(Integer personnelId)
    {
        Personnel personnel = service.selectPersonnelById(personnelId);
        Integer personnelTypeId = personnel.getPersonnelTypeId();
        String typeName = personnelTypeService.getById(personnelTypeId).getPersonnelTypeName();
        return new ResultWithStr<>(personnel, 200, typeName);
    }

    @GetMapping("/searchPersonnel")
    public ResultWithInfo<List<Personnel>> searchPersonnel(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<Personnel> pagePersonnel = new Page<>(page + 1, rowsPerPage);
        IPage<Personnel> personnels = service.searchPersonnel(searchContent, pagePersonnel);
        Integer totalPage = Math.toIntExact(personnels.getPages());
        return new ResultWithInfo<>(personnels.getRecords(), 200, totalPage);
    }

    @PostMapping("/editPersonnelById")
    public boolean editPersonnelById(Personnel personnel)
    {
        return service.updatePersonnelById(personnel) == 1;
    }

    @GetMapping("/getPasswordByPersonnelId")
    public Result<String> selectPasswordByPersonnelId(Integer personnelId)
    {
        return new Result<>(service.selectPasswordByPersonnelId(personnelId), 200);
    }
    @PostMapping("/updatePasswordByPersonnelId")
    public Integer updatePasswordByPersonnelId(String personnelPassword, Integer personnelId)
    {
        return service.updatePasswordByPersonnelId(personnelPassword, personnelId);
    }
}

