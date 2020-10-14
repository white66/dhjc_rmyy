package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.JobNumber;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/6/28 9:04
 * @Version 1.0
 */
@Component
public interface JobNumberMapper {

    List<JobNumber> jobNumberList();

    void addJobNumber(JobNumber jobNumber);

    void deleteJobNumberById(JobNumber jobNumber);

    void updateJobNumber(JobNumber jobNumber);
}
