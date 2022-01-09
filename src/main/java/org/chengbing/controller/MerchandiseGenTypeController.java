package org.chengbing.controller;


import org.chengbing.entity.MerchandiseGenType;
import org.chengbing.service.IMerchandiseGenTypeService;
import org.chengbing.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/merchandiseGenType")
public class MerchandiseGenTypeController {
    @Resource
    IMerchandiseGenTypeService service;

    @GetMapping("queryAllType")
    public Result<List<MerchandiseGenType>> queryAll()
    {
        return new Result<>(service.list(), 200);
    }
}

