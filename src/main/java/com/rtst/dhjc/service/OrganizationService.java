package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.OrganizationInfo;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/13 9:40
 * @Version 1.0
 */
public interface OrganizationService {
    List<OrganizationInfo> findOrganizationList(OrganizationInfo organizationInfo);

    int addOrganization(OrganizationInfo organizationInfo);

    int deleteOrganization(OrganizationInfo organizationInfo);

    int updateOrganization(OrganizationInfo organizationInfo);
}
