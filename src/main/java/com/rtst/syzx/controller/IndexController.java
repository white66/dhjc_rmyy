package com.rtst.syzx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.syzx.bean.BaseResult;
import com.rtst.syzx.entity.Signal;
import com.rtst.syzx.service.serviceImpl.SignalServiceImpl;
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
public class IndexController {
    @Autowired
    SignalServiceImpl signalService;

    /**
     * 查询信号表最新的实时数据
     * @return
     */
    @GetMapping("/signalList")
    public BaseResult signalList(){
        PageHelper.startPage(1,40);
        List<Signal> signalList = signalService.getSignalList();
        PageInfo pageInfo = new PageInfo(signalList);
        return BaseResult.ok().put("data",pageInfo);
    }

    /**
     * 查询历史数据
     * @return
     */
    @PostMapping("/signalListHistory")
    public BaseResult signalListHistory(@RequestBody Signal signal){
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
    public BaseResult alarmList(@RequestBody Signal signal){
        PageHelper.startPage(signal.getPageNum(),signal.getPageSize()*4);
        List<Signal> signalList = signalService.getAlarmListHistory(signal);
        PageInfo pageInfo = new PageInfo(signalList);
        return BaseResult.ok().put("data",pageInfo);
    }
}
