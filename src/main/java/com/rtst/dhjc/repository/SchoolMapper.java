package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.SchoolInfo;
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
public interface SchoolMapper {

    List<SchoolInfo> findSchool(SchoolInfo schoolInfo);

    int addSchool(SchoolInfo schoolInfo);

    int deleteSchool(SchoolInfo schoolInfo);

    int updateSchool(SchoolInfo schoolInfo);

    List<SiteInfo> findSiteBySchoolId(SiteInfo siteInfo);
}
