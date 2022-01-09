package org.chengbing.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.AuthenClearance;
import org.chengbing.entity.AuthenItem;
import org.chengbing.entity.AuthenNormal;
import org.chengbing.service.IAuthenNormalService;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
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
@RequestMapping("/authenNormal")
public class AuthenNormalController {
    @Resource
    IAuthenNormalService service;

    @GetMapping("/queryAllAuthenNormal")
    public ResultWithInfo<List<AuthenNormal>> queryAllAuthenNormal(Integer page, Integer rowsPerPage)
    {
        Page<AuthenNormal> pageAuthenItem = new Page<>(page + 1, rowsPerPage);
        IPage<AuthenNormal> authenNormals = service.selectPageAuthenNormal(pageAuthenItem);
        Integer totalRows = Math.toIntExact(authenNormals.getPages());
        return new ResultWithInfo<>(authenNormals.getRecords(), 200, totalRows);
    }

    @GetMapping("queryAllAuthenNormalAll")
    public Result<List<AuthenNormal>> queryAllAuthenNormalAll()
    {
        return new Result<>(service.list(), 200);
    }

    @PostMapping("/addNewAuthenNormal")
    public Integer addNewAuthenNormal(AuthenNormal authenNormal)
    {
        return service.insertAuthenNormal(authenNormal);
    }

    @DeleteMapping("/removeAuthenNormalById")
    public boolean removeAuthenNormal(Integer authId)
    {
        return service.removeById(authId);
    }

    @GetMapping("/getAuthenNormalById")
    public Result<AuthenNormal> getAuthenNormalById(Integer authId)
    {
        return new Result<>(service.getById(authId), 200);
    }

    @GetMapping("/searchAuthenNormal")
    public ResultWithInfo<List<AuthenNormal>> searchAuthenNormal(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<AuthenNormal> pageAuthenNormal = new Page<>(page + 1, rowsPerPage);
        IPage<AuthenNormal> authenNormals = service.searchAuthenNormal(searchContent, pageAuthenNormal);
        Integer totalPage = Math.toIntExact(authenNormals.getPages());
        return new ResultWithInfo<>(authenNormals.getRecords(), 200, totalPage);
    }

    @PostMapping("/editAuthenNormalById")
    public boolean editAuthenNormalById(AuthenNormal authenNormal)
    {
        return service.updateById(authenNormal);
    }

    @GetMapping("/selectAffiliation")
    public List<LinkedHashMap> selectAffiliation(Integer authId) {
        return service.selectAffiliation(authId);
    }

    @PostMapping("/addNewClearance")
    public Integer insertClearance(AuthenClearance clearance) {
        return service.insertClearance(clearance);
    }

    @DeleteMapping("removeClearance")
    public Integer deleteClearance(Integer authenId, Integer authenItemId) {
        return service.deleteClearance(authenId, authenItemId);
    }

}

