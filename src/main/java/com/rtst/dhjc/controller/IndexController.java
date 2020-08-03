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
    @ApiOperation(value="通过schoolId查询最新电表、IO模块、UPS实时数据)")
    public BaseResult signalList(@RequestBody @ApiParam(name="学校ID,模块标识，参数类型",value = "schoolId,flag，startTypeFlag,endTypeFlag",required = true) Signal signal){
        List<Signal> signalList = signalService.getSignalList(signal);
        return BaseResult.ok().put("data",signalList);
    }

    @PostMapping("/signalAlarmList")
    @ApiOperation(value = "查询实时告警信息")
    public BaseResult signalAlarmList(@RequestBody @ApiParam(name="学校ID",value="schoolId",required = true) Signal signal){
        List<Signal> signals = signalService.getSignalAlarmList(signal);
        return BaseResult.ok().put("data",signals);
    }
    /**
     * 查询历史数据
     * @return
     */
    @PostMapping("/signalListHistory")
    @ApiOperation(value = "查询历史数据(分页),按照电流、电压、功率、电能来分类分模块查询")
    public BaseResult signalListHistory( @ApiParam(name="信号对象",value="schoolId,flag,dsigDateTime,pageNum,pageSize,sigUnit,typeFlag",required = true) @RequestBody Signal signal){
        int parameter = parameterService.findParameterByUnit(signal);
        PageHelper.startPage(signal.getPageNum(),signal.getPageSize()*parameter);
        List<Signal> signalList = signalService.getSignalListHistory(signal);
        PageInfo pageInfo = new PageInfo(signalList);
        return BaseResult.ok().put("data",pageInfo);
    }
    /**
     * 状态列表
     * @param signal
     * @return
     */
    @PostMapping("/alarmList")
    @ApiOperation(value = "状态列表(分页)")
    public BaseResult alarmList(@RequestBody @ApiParam(name="信号对象",value="schoolId,dsigDateTime,pageNum,pageSize",required = true) Signal signal){
        PageHelper.startPage(signal.getPageNum(),signal.getPageSize()*4);
        List<Signal> signalList = signalService.getAlarmListHistory(signal);
        PageInfo pageInfo = new PageInfo(signalList);
        return BaseResult.ok().put("data",pageInfo);
    }
}
