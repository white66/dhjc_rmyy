package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.systemInfo.User;
import com.rtst.dhjc.service.serviceImpl.systemInfo.RoleServiceImpl;
import com.rtst.dhjc.service.serviceImpl.systemInfo.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  用户管理
 * </p>
 */
@RestController
@RequestMapping("/api/user")
@Api(tags="用户管理")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    /**
     * 查询用户列表.
     * @return
     */
    @PostMapping("/userList")
    //@RequiresPermissions("user:view")//权限管理;
    @ApiOperation(value="查询所有用户列表（分页）")
    public BaseResult listUsers(@RequestBody  @ApiParam(name="页码，行数",value="pageNum,pageSize",required = true) User user){
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        List<User> users = userService.listUsers();
        PageInfo pageInfo = new PageInfo(users);
        return BaseResult.ok().put("data",pageInfo);
    }
    /**
     * 用户添加;
     * @return
     */
    @PostMapping("/userAdd")
    //@RequiresPermissions("user:add")//权限管理;
    @ApiOperation(value="用户注册")
    public BaseResult userInfoAdd(@RequestBody @ApiParam(name="用户对象",value="userName,passWord,organizationId,state,expiredDate,createTime",required = true) User user){
        Map<String,Object> resultMap = userService.addUser(user);
        return BaseResult.ok(resultMap);
    }
    /**
     * 用户删除;
     * @return
     */
    @DeleteMapping("/userDel")
    @RequiresPermissions("user:del")//权限管理;
    @ApiOperation(value="删除用户")
    public BaseResult userDel(@RequestBody @ApiParam(name = "用户ID",value="userId",required = true) User user){
        int result = userService.deleteUser(user);
        if(result>0){
            return BaseResult.ok().put("msg","删除用户");
        }
        return BaseResult.error(400,"删除失败");
    }
    /**
     * 通过用户名userName查询用户信息
     * @param user
     * @return
     */
    @PostMapping("/userOne")
    @ApiOperation(value="通过用户名userName查询用户信息")
    public BaseResult selectUserByUserName(@RequestBody @ApiParam(name="用户名",value="userName",required = true) User user){
        User userInfo = userService.findUserByAccount(user.getUserName());
        return BaseResult.ok().put("查询成功",userInfo);
    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
    @ApiOperation(value = "修改用户信息")
    public BaseResult updateUser(@RequestBody @ApiParam(name="用户对象User", value="userName,passWord,organizationId,state,expiredDate",required = true) User user){
        int result = userService.updateUser(user);
        if(result>0){
            return BaseResult.ok().put("msg","修改用户信息成功");
        }
        return BaseResult.error(400,"修改用户信息失败");
    }
    /**
     * 重置用户密码，默认为123456
     * @param user
     * @return
     */
    @PostMapping("/userReSet")
    @ApiOperation(value="重置用户密码为123456")
    public BaseResult reSetPassWord(@RequestBody @ApiParam(name="用户ID",value="userId",required = true) User user){
        user.setPassWord("123456");
        int result = userService.updateUser(user);
        if(result>0){
            return BaseResult.ok().put("msg","重置密码成功");
        }
        return BaseResult.error(400,"重置密码失败");
    }
}
