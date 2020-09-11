package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.OrganizationInfo;
import com.rtst.dhjc.repository.OrganizationMapper;
import com.rtst.dhjc.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/13 9:40
 * @Version 1.0
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;
    @Override
    public List<OrganizationInfo> findOrganizationList(OrganizationInfo organizationInfo) {
        List<OrganizationInfo> OrganizationInfos = organizationMapper.findOrganization(organizationInfo);
        return OrganizationInfos;
    }

    @Override
    public int addOrganization(OrganizationInfo organizationInfo) {
        int refNum = organizationMapper.addOrganization(organizationInfo);
        return refNum;
    }

    @Override
    public int deleteOrganization(OrganizationInfo organizationInfo) {
        int refNum = organizationMapper.deleteOrganization(organizationInfo);
        return refNum;
    }

    @Override
    public int updateOrganization(OrganizationInfo organizationInfo) {
        int refNum = organizationMapper.updateOrganization(organizationInfo);
        return refNum;
    }
}
