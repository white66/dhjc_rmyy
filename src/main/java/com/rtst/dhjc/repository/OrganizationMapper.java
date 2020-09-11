package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.OrganizationInfo;
import com.rtst.dhjc.entity.SiteInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/13 9:43
 * @Version 1.0
 */
@Component
public interface OrganizationMapper {

    List<OrganizationInfo> findOrganization(OrganizationInfo organizationInfo);

    int addOrganization(OrganizationInfo organizationInfo);

    int deleteOrganization(OrganizationInfo organizationInfo);

    int updateOrganization(OrganizationInfo organizationInfo);

}
