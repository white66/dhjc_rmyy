package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.SiteInfo;
import com.rtst.dhjc.repository.SiteMapper;
import com.rtst.dhjc.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/5/19 14:06
 * @Version 1.0
 */
@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    SiteMapper siteMapper;

    @Override
    public List<SiteInfo> findSiteBySchoolId(SiteInfo siteInfo) {
        List<SiteInfo> siteInfos = siteMapper.findSiteBySchoolId(siteInfo);
        return siteInfos;
    }

    @Override
    public int addSite(SiteInfo siteInfo) {
        int refNum = siteMapper.addSite(siteInfo);
        return refNum;
    }

    @Override
    public int deleteSite(SiteInfo siteInfo) {
        int refNum = siteMapper.deleteSite(siteInfo);
        return refNum;
    }

    @Override
    public int deleteSiteBySchoolId(SiteInfo siteInfo) {
        int refNum = siteMapper.deleteSiteBySchoolId(siteInfo);
        return refNum;
    }
}
