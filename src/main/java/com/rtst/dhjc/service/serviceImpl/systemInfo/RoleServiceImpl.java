package com.rtst.dhjc.service.serviceImpl.systemInfo;

import com.rtst.dhjc.entity.systemInfo.Role;
import com.rtst.dhjc.entity.systemInfo.UserRole;
import com.rtst.dhjc.repository.systemInfo.RoleMapper;
import com.rtst.dhjc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    /**
     * 根据用户Id查询用户所拥有的角色信息
     * @param userId
     * @return
     */
    @Override
    public List<Role> findRoleByUserId(Integer userId) {
        List<Role> roles = roleMapper.findRoleByUserId(userId);
        return roles;
    }
    /**
     * 查询角色列表
     * @return
     */
    @Override
    public List<Role> roleList() {
        List<Role> roles = roleMapper.roleList();
        return roles;
    }

    @Override
    public int updateUserRole(UserRole userRole) {
        int refNum = roleMapper.updateUserRole(userRole);
        return refNum;
    }
}
