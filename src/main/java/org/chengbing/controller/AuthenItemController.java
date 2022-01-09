package org.chengbing.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.AuthenItem;
import org.chengbing.service.IAuthenItemService;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithInfo;
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
@RequestMapping("/authenItem")
public class AuthenItemController {
    @Resource
    IAuthenItemService service;

    @GetMapping("/queryAllAuthenItem")
    public ResultWithInfo<List<AuthenItem>> queryAllAuthenItem(Integer page, Integer rowsPerPage)
    {
        Page<AuthenItem> pageAuthenItem = new Page<>(page + 1, rowsPerPage);
        IPage<AuthenItem> authenItems = service.selectPageAuthenItem(pageAuthenItem);
        Integer totalRows = Math.toIntExact(authenItems.getPages());
        return new ResultWithInfo<>(authenItems.getRecords(), 200, totalRows);
    }

    @GetMapping("queryAllAuthenItemAll")
    public Result<List<AuthenItem>> queryAllAuthenItemAll()
    {
        return new Result<>(service.list(), 200);
    }

    @PostMapping("/addNewAuthenItem")
    public Integer addNewAuthenItem(AuthenItem authenItem)
    {
        return service.insertAuthenItem(authenItem);
    }

    @DeleteMapping("/removeAuthenItem")
    public boolean removeAuthenItemById(Integer authenItemId)
    {
        return service.removeById(authenItemId);
    }

    @GetMapping("/getAuthenItemById")
    public Result<AuthenItem> getRegionById(Integer authenItemId)
    {
        return new Result<>(service.getById(authenItemId), 200);
    }

    @GetMapping("/searchAuthenItem")
    public ResultWithInfo<List<AuthenItem>> searchRegion(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<AuthenItem> pageRegion = new Page<>(page + 1, rowsPerPage);
        IPage<AuthenItem> authenItems = service.searchAuthenItem(searchContent, pageRegion);
        Integer totalPage = Math.toIntExact(authenItems.getPages());
        return new ResultWithInfo<>(authenItems.getRecords(), 200, totalPage);
    }

    @PostMapping("/editAuthenItemById")
    public boolean editRegionById(AuthenItem authenItem)
    {
        return service.updateById(authenItem);
    }
}

