package com.rtst.dhjc.repository.systemInfo;

import com.rtst.dhjc.entity.systemInfo.User;
import com.rtst.dhjc.entity.systemInfo.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    /**
     * 通过账户查询用户信息
     * @param userAccount
     * @return
     */
    User findUserByAccount(String userAccount);

    /**
     * 查詢用戶列表
     * @return
     */
    List<User> findUserList();

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    int deleteUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 通过学校Id查询当前学校已注册的用户人数
     * @param schoolId
     * @return
     */
    int findUserByOrganizationId(Integer schoolId);

    UserRole findRoleByUserName(String userName);
}
