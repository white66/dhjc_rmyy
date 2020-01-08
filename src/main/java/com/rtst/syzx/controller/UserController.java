package com.rtst.syzx.controller;

import com.github.pagehelper.PageHelper;
import com.rtst.syzx.bean.BaseResult;
import com.rtst.syzx.entity.systemInfo.User;
import com.rtst.syzx.service.serviceImpl.systemInfo.UserServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  管理用户前端控制器
 * </p>
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    /**
     * 用户查询.
     * @return
     */
    @GetMapping("/userList")
    @RequiresPermissions("user:view")//权限管理;
    public BaseResult listUsers(@RequestBody int pageNo, @RequestBody int pageNum){
        PageHelper.startPage(pageNo,pageNum);
        List<User> users = userService.listUsers();
        return BaseResult.ok().put("查询成功",users);
    }
    /**
     * 用户添加;
     * @return
     */
    @PostMapping("/userAdd")
    @RequiresPermissions("user:add")//权限管理;
    public BaseResult userInfoAdd(@RequestBody User user){
        Map<String,Object> resultMap = userService.addUser(user);
        return BaseResult.ok(resultMap);
    }
    /**
     * 用户删除;
     * @return
     */
    @DeleteMapping("/userDel")
    @RequiresPermissions("user:del")//权限管理;
    public BaseResult userDel(@RequestBody User user){
        Map<String,Object> resultMap = userService.delUser(user);
        return BaseResult.ok(resultMap);
    }
    /**
     * 通过用户名userName查询用户信息
     * @param userName
     * @return
     */
    @GetMapping("/userOne")
    public BaseResult selectUserByUserName(@RequestBody String userName){
        User user = userService.findUserByAccount(userName);
        return BaseResult.ok().put("查询成功",user);
    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
    public BaseResult updateUser(@RequestBody User user){
        Map<String,Object> resultMap = userService.updateUser(user);
        return BaseResult.ok(resultMap);
    }
    /**
     * 重置用户密码，默认为123456
     * @param user
     * @return
     */
    @PostMapping("/userReSet")
    public BaseResult reSetPassWord(@RequestBody User user){
        user.setPassWord("123456");
        Map<String,Object> resultMap = userService.updateUser(user);
        return BaseResult.ok(resultMap);
    }
}
