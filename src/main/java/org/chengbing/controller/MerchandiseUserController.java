package org.chengbing.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.Region;
import org.chengbing.service.IMerchandiseService;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userMerch")
public class MerchandiseUserController {
    @Resource
    IMerchandiseService service;

    @GetMapping("/selectMainPage")
    public Result<List<Map>> selectMainPage() {
        return new Result<>(service.selectMainPage(), 200);
    }

    @GetMapping("/selectMainPageBySaleAmount")
    public Result<List<Map>> selectMainPageBySaleAmount() {
        return new Result<>(service.selectMainPageBySaleAmount(), 200);
    }

}
