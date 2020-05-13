package com.rtst.dhjc.repository.systemInfo;

import com.rtst.dhjc.entity.systemInfo.Permission;
import com.rtst.dhjc.entity.systemInfo.Role;
import com.rtst.dhjc.entity.systemInfo.RolePermission;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface AuthMapper {
    /**
     * 通过角色Id查询角色的权限信息
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
    int authAdd(Permission permission);

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    int authDel(Integer permissionId);

    /**
     * 修改权限
     * @param permission
     * @return
     */
    int authUpdate(Permission permission);

    List<Permission> findAuthByRoleId(Role role);

    List<Permission> findAuthAll();

    int addPermissionForRole(List<RolePermission> permissionsAdd);

    int deletePermissionForRole(List<RolePermission> permissionsDelete);

    List<RolePermission> findAuthByRoleIdAndPermission(RolePermission rolePermission);
}
