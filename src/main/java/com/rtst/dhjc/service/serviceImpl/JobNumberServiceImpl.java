package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.JobNumber;
import com.rtst.dhjc.repository.JobNumberMapper;
import com.rtst.dhjc.service.JobNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能模块(告警功能)
 *
 * @Author white Liu
 * @Date 2020/6/28 8:54
 * @Version 1.0
 */
@Service
public class JobNumberServiceImpl implements JobNumberService {
    @Autowired
    JobNumberMapper jobNumberMapper;

    @Override
    public List<JobNumber> jobNumberList() {
        List<JobNumber> jobNumberList = jobNumberMapper.jobNumberList();
        return jobNumberList;
    }

    @Override
    public void addJobNumber(JobNumber jobNumber) {
        jobNumberMapper.addJobNumber(jobNumber);
    }

    @Override
    public void deleteJobNumberById(JobNumber jobNumber) {
        jobNumberMapper.deleteJobNumberById(jobNumber);
    }

    @Override
    public void updateJobNumber(JobNumber jobNumber) {
        jobNumberMapper.updateJobNumber(jobNumber);
    }
}
