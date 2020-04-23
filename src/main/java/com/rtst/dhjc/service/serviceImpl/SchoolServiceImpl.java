package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.SchoolInfo;
import com.rtst.dhjc.repository.SchoolMapper;
import com.rtst.dhjc.service.SchoolService;
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
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolMapper schoolMapper;
    @Override
    public List<SchoolInfo> findSchoolList(SchoolInfo schoolInfo) {
        List<SchoolInfo> schoolInfos = schoolMapper.findSchool(schoolInfo);
        return schoolInfos;
    }

    @Override
    public int addSchool(SchoolInfo schoolInfo) {
        int refNum = schoolMapper.addSchool(schoolInfo);
        return refNum;
    }

    @Override
    public int deleteSchool(SchoolInfo schoolInfo) {
        int refNum = schoolMapper.deleteSchool(schoolInfo);
        return refNum;
    }

    @Override
    public int updateSchool(SchoolInfo schoolInfo) {
        int refNum = schoolMapper.updateSchool(schoolInfo);
        return refNum;
    }
}
