package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.SiteInfo;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/5/19 14:07
 * @Version 1.0
 */
public interface SiteService {

    List<SiteInfo> findSiteBySchoolId(SiteInfo siteInfo);

    int addSite(SiteInfo siteInfo);

    int deleteSite(SiteInfo siteInfo);

    int deleteSiteBySchoolId(SiteInfo siteInfo);
}
