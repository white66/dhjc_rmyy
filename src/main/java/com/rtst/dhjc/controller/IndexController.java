package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.Signal;
import com.rtst.dhjc.service.serviceImpl.ParameterServiceImpl;
import com.rtst.dhjc.service.serviceImpl.SignalServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页控制器
 * @Author white Liu
 * @Date 2019/12/10 9:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/signal")
@Api(tags="首页显示相关接口")
public class IndexController {
    @Autowired
    SignalServiceImpl signalService;
    @Autowired
    ParameterServiceImpl parameterService;
    /**
     * 查询信号表最新的实时数据
     * @return
     */
    @PostMapping("/signalList")
    @ApiOperation(value="通过schoolId查询最新实时数据)")
    public BaseResult signalList(@RequestBody @ApiParam(name="学校ID",value = "schoolId,flag",required = true) Signal signal){
        int parameterInfos = parameterService.findParameterByState(signal);
        PageHelper.startPage(1,parameterInfos);
        List<Signal> signalList = signalService.getSignalList(signal);
        PageInfo pageInfo = new PageInfo(signalList);
        return BaseResult.ok().put("data",pageInfo);
    }

    /**
     * 查询历史数据
     * @return
     */
    @PostMapping("/signalListHistory")
    @ApiOperation(value = "查询历史数据(分页)")
    public BaseResult signalListHistory(@RequestBody @ApiParam(name="信号对象",value="schoolId,flag,dsigDateTime,pageNum,pageSize",required = true) Signal signal){
        int parameterInfos = parameterService.findParameterByState(signal);
        PageHelper.startPage(signal.getPageNum(),signal.getPageSize()*parameterInfos);
        List<Signal> signalList = signalService.getSignalListHistory(signal);
        PageInfo pageInfo = new PageInfo(signalList);
        return BaseResult.ok().put("data",pageInfo);
    }

    /**
     * 告警列表
     * @param signal
     * @return
     */
    @PostMapping("/alarmList")
    @ApiOperation(value = "告警信息列表(分页)")
    public BaseResult alarmList(@RequestBody @ApiParam(name="信号对象",value="schoolId,dsigDateTime,pageNum,pageSize",required = true) Signal signal){
        PageHelper.startPage(signal.getPageNum(),signal.getPageSize()*4);
        List<Signal> signalList = signalService.getAlarmListHistory(signal);
        PageInfo pageInfo = new PageInfo(signalList);
        return BaseResult.ok().put("data",pageInfo);
    }
}
