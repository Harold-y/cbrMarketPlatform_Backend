package org.chengbing.controller;


import cn.dev33.satoken.stp.StpUtil;
import org.chengbing.service.IPersonnelService;
import org.chengbing.service.IUtilService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/util")
public class UtilController {

    @Resource
    IUtilService service;

    @Resource
    IPersonnelService personnelService;

    @GetMapping("/uploadFolder")
    public String getUploadFolder()
    {
        return service.getUploadFolder();
    }

    @GetMapping("/getPermissionList")
    public List<String> getPermissionList() {
        return personnelService.personnelAuth(Integer.parseInt((String) StpUtil.getLoginId()));
    }
}
