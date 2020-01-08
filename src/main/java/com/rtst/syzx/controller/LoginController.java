package com.rtst.syzx.controller;

import com.rtst.syzx.bean.BaseResult;
import com.rtst.syzx.bean.CacheUser;
import com.rtst.syzx.entity.systemInfo.User;
import com.rtst.syzx.service.serviceImpl.systemInfo.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    /**
     * 登陆操作
     * @param user
     * @return
     */
    @PostMapping("/login")
    public BaseResult login(@RequestBody User user){
        log.warn("进入登录....");
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        if(null==userName||" ".equals(userName)){
            return  BaseResult.error("用户名不能为空！");
        }
        if(null==passWord||" ".equals(passWord)){
            return BaseResult.error("密码不能为空！");
        }
        CacheUser loginUser =  userService.login(userName,passWord);
        // 登录成功返回用户信息
        return BaseResult.ok().put("data",loginUser);
    }
    /**
     * description: 登出
     * create time: 2019/6/28 17:37
     */
    @GetMapping("/logout")
    public BaseResult logOut() {
        userService.logout();
        return BaseResult.ok("登出成功！");
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping("/un_auth")
    public BaseResult unAuth() {
        return BaseResult.error(401, "用户未登录！");
    }

    /**
     * 未授权，无权限，此处返回未授权状态信息由前端控制跳转页面
     * create time: 2019/7/3 14:53
     * @return
     */
    @RequestMapping("/unauthorized")
    public BaseResult unauthorized() {
        return BaseResult.error(403, "用户无权限！");
    }
}
