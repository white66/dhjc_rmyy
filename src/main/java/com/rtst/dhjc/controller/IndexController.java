package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.ParameterInfo;
import com.rtst.dhjc.entity.Signal;
import com.rtst.dhjc.service.serviceImpl.ParameterServiceImpl;
import com.rtst.dhjc.service.serviceImpl.SignalServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public BaseResult signalList(@RequestBody @ApiParam(name="学校ID",value = "schoolId",required = true) Signal signal){
        List<ParameterInfo> parameterInfos = parameterService.findParameterByState();
        PageHelper.startPage(1,parameterInfos.size());
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
    public BaseResult signalListHistory(@RequestBody @ApiParam(name="信号对象",value="schoolId,dsigDateTime,pageNum,pageSize",required = true) Signal signal){
        PageHelper.startPage(signal.getPageNum(),signal.getPageSize()*40);
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
