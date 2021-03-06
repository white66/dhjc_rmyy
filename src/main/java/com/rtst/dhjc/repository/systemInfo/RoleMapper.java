package com.rtst.dhjc.repository.systemInfo;

import com.rtst.dhjc.entity.systemInfo.Role;
import com.rtst.dhjc.entity.systemInfo.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {
    /**
     * 根据用户的ID查询用户所拥有的的角色信息
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(Integer userId);

    /**
     * 查询角色列表
     * @return
     */
    List<Role> roleList();

    /**
     * 添加角色
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    int delRole(Integer roleId);

    /**
     * 修改角色
     * @param role
     * @return
     */
    int updateRole(Role role);

    void addUserRole(UserRole userRole);

    int updateUserRole(UserRole userRole);
}
