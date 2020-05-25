package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.SchoolInfo;
import com.rtst.dhjc.entity.SiteInfo;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/13 9:40
 * @Version 1.0
 */
public interface SchoolService {
    List<SchoolInfo> findSchoolList(SchoolInfo schoolInfo);

    int addSchool(SchoolInfo schoolInfo);

    int deleteSchool(SchoolInfo schoolInfo);

    int updateSchool(SchoolInfo schoolInfo);
}
