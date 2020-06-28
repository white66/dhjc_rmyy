package com.rtst.dhjc.service.serviceImpl.systemInfo;

import com.rtst.dhjc.bean.CacheUser;
import com.rtst.dhjc.entity.systemInfo.User;
import com.rtst.dhjc.entity.systemInfo.UserRole;
import com.rtst.dhjc.exception.LoginException;
import com.rtst.dhjc.repository.systemInfo.RoleMapper;
import com.rtst.dhjc.repository.systemInfo.UserMapper;
import com.rtst.dhjc.service.UserService;
import com.rtst.dhjc.util.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    /**
     * 根据账户查询用户信息
     * @param userAccount
     * @return
     */
    @Override
    public User findUserByAccount(String userAccount) {
        User user = userMapper.findUserByAccount(userAccount);
        return user;
    }

    /**
     * 登录时验证用户名和密码是否存在
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public CacheUser login(String userName, String passWord) {
        // 获取Subject实例对象，用户实例
        Subject currentUser = SecurityUtils.getSubject();

        // 将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);

        CacheUser cacheUser;
        // 4、认证
        try {
            // 传到 MyShiroRealm 类中的方法进行认证
            currentUser.login(token);
            // 构建缓存用户信息返回给前端
            User user = (User) currentUser.getPrincipals().getPrimaryPrincipal();
            cacheUser = CacheUser.builder()
                    .token(currentUser.getSession().getId().toString())
                    .build();
            BeanUtils.copyProperties(user, cacheUser);
            UserRole userRole = userMapper.findRoleByUserName(userName);
            cacheUser.setRoleId(userRole.getRoleId());
            log.warn("CacheUser is {}", cacheUser.toString());
        } catch (UnknownAccountException e) {
            log.error("账户不存在异常：", e);
            throw new LoginException("账号不存在!", e);
        } catch (IncorrectCredentialsException e) {
            log.error("凭据错误（密码错误）异常：", e);
            throw new LoginException("密码不正确!", e);
        } catch (AuthenticationException e) {
            log.error("身份验证异常:", e);
            throw new LoginException("用户验证失败!", e);
        }
        return cacheUser;
    }

    /**
     * 登出
     */
    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
    /**
     * 查询用户列表
     * @return
     */
    @Override
    public List<User> listUsers() {
       List<User> users = userMapper.findUserList();
        return users;
    }
    @Override
    public Map<String,Object> addUser(User user) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        if(null!= userMapper.findUserByAccount(user.getUserName())){
            resultMap.put("msg","用户名已存在！");
            resultMap.put("user",user);
            return resultMap;
        }
        int userCount = userMapper.findUserBySchoolId(user.getSchoolId());
        //当前学校注册用户超过10个时，不能再注册新的用户
        if(userCount>=10){
            resultMap.put("msg","该学校注册用户已达上限");
            resultMap.put("code",400);
            return resultMap;
        }
        user.setPassWord(MD5Utils.encrypt(user.getPassWord()));
        int ref = userMapper.addUser(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getUserId());
        //为新注册的用户添加默认角色
        roleMapper.addUserRole(userRole);
        if(ref>0){
            resultMap.put("msg","添加成功！");
            resultMap.put("user",user);
        }else{
            resultMap.put("msg","添加失败！");
        }
        return resultMap;
    }
    /**
     * 根据用户ID删除用户
     * @param user
     * @return
     */
    @Override
    public int deleteUser(User user) {
        int ref = userMapper.deleteUser(user);
        return ref;
    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        if(""!=user.getPassWord()&&null!=user.getPassWord()){
            user.setPassWord(MD5Utils.encrypt(user.getPassWord()));
        }
        int ref = userMapper.updateUser(user);
        return ref;
    }
}
