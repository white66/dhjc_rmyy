package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.SiteInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/5/19 14:08
 * @Version 1.0
 */
@Component
public interface SiteMapper {
    List<SiteInfo> findSiteByOrganizationId(SiteInfo siteInfo);

    int addSite(SiteInfo siteInfo);

    int deleteSite(SiteInfo siteInfo);

    int deleteSiteByOrganizationId(SiteInfo siteInfo);
}
