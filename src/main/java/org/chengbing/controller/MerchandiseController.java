package org.chengbing.controller;


import org.chengbing.entity.Merchandise;
import org.chengbing.service.IMerchandiseService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
@RequestMapping("/merchandise")
public class MerchandiseController {
    @Resource
    IMerchandiseService service;

    @GetMapping("/queryAllMerchandise")
    public ResultWithInfo<List<Map>> queryAllMerchandise(Integer page, Integer rowsPerPage)
    {
        Page<Map> pageMerchandise = new Page<>(page + 1, rowsPerPage);
        IPage<Map> merchandises = service.selectPageMerchandise(pageMerchandise);
        Integer totalPage = Math.toIntExact(merchandises.getPages());
        return new ResultWithInfo<>(merchandises.getRecords(), 200, totalPage);
    }

    @GetMapping("queryAllMerchandiseAll")
    public Result<List<Merchandise>> queryAllMerchandiseAll()
    {
        return new Result<>(service.list(), 200);
    }

    @PostMapping("/addNewMerchandise")
    public Integer addNewMerchandise(Merchandise merchandise)
    {
        return service.insertMerchandise(merchandise);
    }

    @DeleteMapping("/removeMerchandise")
    public boolean removeMerchandiseById(Integer merchandiseId)
    {
        return service.removeById(merchandiseId);
    }

    @DeleteMapping("/inactivateMerchandise")
    public Integer inactivateMerchandise(Integer merchandiseId)
    {
        return service.inactivateMerchandise(merchandiseId);
    }

    @GetMapping("/getMerchandiseById")
    public Result<Map> getMerchandiseById(Integer merchandiseId)
    {
        return new Result<>(service.selectPageMerchandiseById(merchandiseId), 200);
    }

    @GetMapping("/searchMerchandise")
    public ResultWithInfo<List<Map>> searchMerchandise(String searchContent, Integer page, Integer rowsPerPage)
    {
        Page<Map> pageMerchandise = new Page<>(page + 1, rowsPerPage);
        IPage<Map> merchandises = service.searchMerchandise(searchContent, pageMerchandise);
        Integer totalPage = Math.toIntExact(merchandises.getPages());
        return new ResultWithInfo<>(merchandises.getRecords(), 200, totalPage);
    }

    @PostMapping("/editMerchandiseById")
    public boolean editMerchandiseById(Merchandise merchandise)
    {
        return service.updateById(merchandise);
    }

    @PostMapping("/updateMerchandiseImg")
    public void updateMerchandiseImg(MultipartFile img, Integer merchId){
        service.updateMerchandiseImg(img, merchId);
    }
    @DeleteMapping("/removeImage")
    public Integer deleteImage(Integer imageId, Integer merchId)
    {
        return service.deleteImage(imageId, merchId);
    }

    @GetMapping("/getImageFolder")
    public String selectFolder(Integer merchId) {
        return service.selectFolder(merchId);
    }

    @GetMapping("/getImageSet")
    public List<String> selectImageSet(Integer merchId)
    {
        String set = service.selectImageSet(merchId);
        if(set == null || set.equals(""))
            return new ArrayList<>();
        String[] disassembly = set.split("-");
        return Arrays.asList(disassembly);
    }
}

