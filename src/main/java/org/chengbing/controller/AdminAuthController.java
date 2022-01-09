package org.chengbing.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.chengbing.service.IPersonnelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/adminAuth")
public class AdminAuthController {

    @Resource
    IPersonnelService service;

    // 登录  ----
    @RequestMapping("doLogin")
    public SaResult doLogin(String email, String pwd) {
        Integer resId = service.personnelLogIn(email, pwd);
        if(resId != null && resId!=0) {
            StpUtil.login(resId);
            return SaResult.ok(StpUtil.getTokenInfo().getTokenValue());
        }
        return SaResult.error("Login Failed");
    }

    // 查询登录状态  ----
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("isLogin：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ----
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 注销  ----
    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }
}
