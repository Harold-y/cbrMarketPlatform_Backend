package org.chengbing.controller;


import cn.dev33.satoken.stp.StpUtil;
import org.chengbing.service.IPersonnelService;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithStr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/personnelProfile")
public class PersonnelProfileController {

    @Resource
    IPersonnelService service;

    @GetMapping("/selectPersonnelProfileById")
    public Result<Map> selectPersonnelProfileById()
    {
        return new Result<>(service.selectPersonnelProfileById(), 200);
    }
    @PostMapping("/updatePersonnelProfileName")
    public Integer updatePersonnelProfileName(String personnelFirstName, String personnelMidName, String personnelLastName) {
        return service.updatePersonnelProfileName(personnelFirstName, personnelMidName, personnelLastName);
    }
    @PostMapping("/updatePersonnelEmail")
    public Integer updatePersonnelEmail(String personnelEmail) {
        return service.updatePersonnelEmail(personnelEmail);
    }
    @PostMapping("/updateProfileImg")
    public ResultWithStr<Integer> updateProfileImg(MultipartFile img)
    {
        return service.updateProfileImg(img);
    }
    @GetMapping("/getLoginId")
    public Result<Integer> getLoginId()
    {
        return service.getLoginId();
    }
}
