package com.rtst.dhjc.service.serviceImpl.systemInfo;

import com.rtst.dhjc.entity.systemInfo.Permission;
import com.rtst.dhjc.entity.systemInfo.Role;
import com.rtst.dhjc.entity.systemInfo.RolePermission;
import com.rtst.dhjc.repository.systemInfo.AuthMapper;
import com.rtst.dhjc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthMapper authMapper;

    /**
     * 根据角色ID查询所拥有的权限
     * @param roleIds
     * @return
     */
    @Override
    public Set<String> findAuthByRoleIds(List<Integer> roleIds) {
        Set<String> sysAuthInfos = authMapper.findAuthByRoleIds(roleIds);
        return sysAuthInfos;
    }

    /**
     * 查询权限列表
     * @return
     */
    @Override
    public List<Permission> authList() {
        List<Permission> permissionList = authMapper.authList();
        return permissionList;
    }

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @Override
    public Map<String, Object> authAdd(Permission permission) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref= authMapper.authAdd(permission);
        if(ref>0){
            resultMap.put("msg","添加成功");
            resultMap.put("permission",permission);
        }else{
            resultMap.put("msg","添加失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> authDel(Integer permissionId) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = authMapper.authDel(permissionId);
        if(ref>0){
            resultMap.put("msg","删除成功");
        }else{
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> authUpdate(Permission permission) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = authMapper.authUpdate(permission);
        if(ref>0){
            resultMap.put("msg","修改成功");
            resultMap.put("permission",permission);
        }else{
            resultMap.put("msg","修改失败");
        }
        return resultMap;
    }

    @Override
    public List<Permission> findAuthByRoleId(Role role) {
        List<Permission> permissions = authMapper.findAuthByRoleId(role);
        return permissions;
    }

    @Override
    public List<Permission> findAuthAll() {
        List<Permission> permissions = authMapper.findAuthAll();
        return permissions;
    }

    @Override
    public int updatePermission(List<RolePermission> permissions) {
        List<RolePermission> permissionsAdd = new ArrayList<>();
        List<RolePermission> permissionsDelete = new ArrayList<>();
        //通过for循环取出List中的对象，首先判断他的状态值state是0还是1,0就是从表中删除该角色的该权限，1就是给该角色添加该权限
        //从表中查询是否该角色已经存在该权限，如果存在则不会放入集合中传入到Dao层中
        for(int i=0;i<permissions.size();i++){
            List<RolePermission> rolePermissions = authMapper.findAuthByRoleIdAndPermission(permissions.get(i));
            if(permissions.get(i).getState()==1){
               if(rolePermissions.size()==0){
                   permissionsAdd.add(permissions.get(i));
               }
           }else if(permissions.get(i).getState()==0){
               if(rolePermissions.size()>0){
                   permissionsDelete.add(permissions.get(i));
               }
           }
        }
        int refNumAdd = 0;
        int refNumDelete = 0;
        if(permissionsAdd.size()>0){
            refNumAdd = authMapper.addPermissionForRole(permissionsAdd);
        }
        if(permissionsDelete.size()>0){
            refNumDelete = authMapper.deletePermissionForRole(permissionsDelete);
        }
        return refNumAdd+refNumDelete;
    }
}
