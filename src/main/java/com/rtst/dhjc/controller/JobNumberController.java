package com.rtst.dhjc.controller;

import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.JobNumber;
import com.rtst.dhjc.service.serviceImpl.JobNumberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能模块(工号)
 *
 * @Author white Liu
 * @Date 2020/6/28 8:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/jobNumber")
@Api(tags = "工号管理")
public class JobNumberController {
    @Autowired
    JobNumberServiceImpl jobNumberService;

    @GetMapping("/jobNumberList")
    @ApiOperation(value = "查询工号信息")
    public BaseResult jobNumberList(){
        List<JobNumber> jobNumbers = jobNumberService.jobNumberList();
        return BaseResult.ok().put("data",jobNumbers);
    }

    @PostMapping("/addJobNumber")
    @ApiOperation(value = "添加工号")
    public BaseResult addJobNumber(@RequestBody JobNumber jobNumber){
        jobNumberService.addJobNumber(jobNumber);
        return BaseResult.ok("添加成功");
    }
    @ApiOperation(value = "删除工号")
    @DeleteMapping("/deleteJobNumber")
    public BaseResult deleteJobNumber(@RequestBody JobNumber jobNumber){
        jobNumberService.deleteJobNumberById(jobNumber);
        return BaseResult.ok("删除成功");
    }
    @PostMapping("/updateJobNumber")
    @ApiOperation(value = "修改工号")
    public BaseResult updateJobNumber(@RequestBody JobNumber jobNumber ){
        jobNumberService.updateJobNumber(jobNumber);
        return BaseResult.ok("修改成功");
    }
}
