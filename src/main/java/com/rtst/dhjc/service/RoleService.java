package com.rtst.dhjc.service;


import com.rtst.dhjc.entity.systemInfo.Role;
import com.rtst.dhjc.entity.systemInfo.UserRole;

import java.util.List;

public interface RoleService {
    /**
     * 通过用户Id查询用户所拥有的角色信息
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(Integer userId);

    /**
     * 查询所有角色列表
     * @return
     */
    List<Role> roleList();

    /**
     * 更改用户的角色
     * @param userRole
     * @return
     */
    int updateUserRole(UserRole userRole);
}
