package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.SignalCollectInfo;
import com.rtst.dhjc.service.serviceImpl.SignalCollectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能模块(信号采集配置)
 *
 * @Author white Liu
 * @Date 2020/4/13 10:05
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/signal")
public class SignalCollectController {
    @Autowired
    SignalCollectServiceImpl signalCollectService;

    /**
     * 查询信号采集配置(条件模糊查询)
     * @return
     */
    @PostMapping("/signalCollectListByDeviceName")
    public BaseResult findSignalCollectListByDeviceName(@RequestBody SignalCollectInfo signalCollectInfo){
        PageHelper.startPage(signalCollectInfo.getPageNum(),signalCollectInfo.getPageSize());
        List<SignalCollectInfo> signalCollectInfos = signalCollectService.findSignalCollectListByDeviceName(signalCollectInfo);
        PageInfo pageInfo = new PageInfo(signalCollectInfos);
        return BaseResult.ok().put("data",pageInfo);
    }

    /**
     * 查询所有信号采集配置（分页）
     * @return
     */
    @PostMapping("/findSignalCollectList")
    public BaseResult findSignalCollectList(@RequestBody SignalCollectInfo signalCollectInfo){
        PageHelper.startPage(signalCollectInfo.getPageNum(),signalCollectInfo.getPageSize());
        List<SignalCollectInfo> signalCollectInfos = signalCollectService.findSignalCollectList();
        PageInfo pageInfo = new PageInfo(signalCollectInfos);
        return BaseResult.ok().put("data",pageInfo);
    }

    /**
     * 配置信号采集信息
     * @param signalCollectInfo
     * @return
     */
    @PostMapping("/addSignalCollect")
    public BaseResult addSignalCollect(@RequestBody SignalCollectInfo signalCollectInfo){
        int refNum = signalCollectService.addSignalCollect(signalCollectInfo);
        if(refNum>0){
            return BaseResult.ok("配置信号采集信息成功！");
        }else{
            return BaseResult.error(400,"配置失败！");
        }
    }

    /**
     * 以id删除配置信息
     * @return
     */
    @DeleteMapping("/deleteSignalById")
    public BaseResult deleteSignalCollectById(@RequestBody SignalCollectInfo signalCollectInfo){
        int refNum = signalCollectService.deleteSignalById(signalCollectInfo);
        if(refNum>0){
            return BaseResult.ok("删除成功！");
        }else{
            return BaseResult.error(400,"删除失败！");
        }
    }
    @PostMapping("/updateSignalCollect")
    public BaseResult updateSignalCollect(@RequestBody SignalCollectInfo signalCollectInfo){
        int refNum = signalCollectService.updateSignalCollect(signalCollectInfo);
        if(refNum>0){
            return BaseResult.ok("修改配置信息com端口："+signalCollectInfo.getComPort()+";设备ID："+signalCollectInfo.getDeviceId()+"成功");
        }else{
            return BaseResult.error(400,"修改配置信息失败!");
        }
    }
}
