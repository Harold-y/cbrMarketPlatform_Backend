package org.chengbing.filter;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册Sa-Token的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册路由拦截器，自定义认证规则
        registry.addInterceptor(new SaRouteInterceptor((req, res, handler) -> {
            //开放 Swagger 2
            SaRouter.match("/swagger-ui.html").check(r -> System.out.println("Get into Swagger 2")).stop();

            // 登录认证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
            //SaRouter.match("/**", "/adminAuth/doLogin", r -> StpUtil.checkLogin());

            /*// 角色认证 -- 拦截以 admin 开头的路由，必须具备 admin 角色或者 super-admin 角色才可以通过认证
            SaRouter.match("/admin/**", r -> StpUtil.checkRoleOr("admin", "super-admin"));*/

            // 权限认证 -- 不同模块认证不同权限
            SaRouter.match("/authenItem/**", r -> StpUtil.checkPermission("Authen"));
            SaRouter.match("/authenNormal/**", r -> StpUtil.checkPermission("Authen"));
            SaRouter.match("/city/**", r -> StpUtil.checkPermission("Grand Pass"));
            SaRouter.match("/region/**", r -> StpUtil.checkPermission("Grand Pass"));
            SaRouter.match("/state/**", r -> StpUtil.checkPermission("Grand Pass"));
            SaRouter.match("/merchandise/**", r -> StpUtil.checkPermission("Merchandise"));
            SaRouter.match("/merchandiseGenType/**", r -> StpUtil.checkPermission("Merchandise"));
            SaRouter.match("/merchandisePropertyType/**", r -> StpUtil.checkPermission("Merchandise"));
            SaRouter.match("/merchandiseType/**", r -> StpUtil.checkPermission("Merchandise"));
            SaRouter.match("/personnel/**", r -> StpUtil.checkPermission("Personnel"));
            SaRouter.match("/personnelType/**", r -> StpUtil.checkPermission("Personnel"));
            SaRouter.match("/seller/**", r -> StpUtil.checkPermission("Seller"));
            SaRouter.match("/personnelProfile/**", r -> StpUtil.checkLogin());


            /*// 甚至你可以随意的写一个打印语句
            SaRouter.match("/**", r -> System.out.println("----啦啦啦----"));

            // 连缀写法
            SaRouter.match("/**").check(r -> System.out.println("----啦啦啦----"));*/

        })).addPathPatterns("/**");
    }
}