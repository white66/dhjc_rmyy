package com.rtst.dhjc.service;


import com.rtst.dhjc.entity.systemInfo.Permission;
import com.rtst.dhjc.entity.systemInfo.Role;
import com.rtst.dhjc.entity.systemInfo.RolePermission;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AuthService {
    /**
     * 根据角色ID查询所拥有的权限
     * @param roleIds
     * @return
     */
    Set<String> findAuthByRoleIds(List<Integer> roleIds);

    /**
     * 查询权限列表
     * @return
     */
    List<Permission> authList();

    /**
     * 添加权限
     * @param permission
     * @return
     */
    Map<String,Object> authAdd(Permission permission);

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    Map<String,Object> authDel(Integer permissionId);

    /**
     * 修改权限
     * @param permission
     * @return
     */
    Map<String,Object> authUpdate(Permission permission);

    /**
     * 根据角色ID查询当前角色所拥有的的页面权限
     * @param role
     * @return
     */
    List<Permission> findAuthByRoleId(Role role);

    /**
     * 查询所有页面信息
     * @return
     */
    List<Permission> findAuthAll();

    int updatePermission(List<RolePermission> permissions);
}
