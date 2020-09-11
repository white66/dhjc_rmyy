package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.SignalCollectInfo;
import com.rtst.dhjc.service.serviceImpl.SignalCollectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags="信号采集配置相关")
public class SignalCollectController {
    @Autowired
    SignalCollectServiceImpl signalCollectService;

    /**
     * 查询信号采集配置(条件模糊查询)
     * @return
     */
    @PostMapping("/signalCollectListByDeviceName")
    @ApiOperation(value="通过设备名查询信号采集配置(模糊查询)(分页)")
    public BaseResult findSignalCollectListByDeviceName(@RequestBody @ApiParam(name="设备名称",value="deviceName",required = false) SignalCollectInfo signalCollectInfo){
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
    @ApiOperation(value ="查询所有信号采集配置(分页)")
    public BaseResult findSignalCollectList(@RequestBody @ApiParam(name = "页码,行数",value="pageNum,pageSize",required = true) SignalCollectInfo signalCollectInfo){
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
    @ApiOperation(value="添加采集配置信息")
    public BaseResult addSignalCollect(@RequestBody @ApiParam(name="学校id,COM端口号",value="organizationId,comPort",required = true) SignalCollectInfo signalCollectInfo){
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
    @ApiOperation(value = "以id删除配置信息")
    public BaseResult deleteSignalCollectById(@RequestBody @ApiParam(name="编号id",value="id",required = true) SignalCollectInfo signalCollectInfo){
        int refNum = signalCollectService.deleteSignalById(signalCollectInfo);
        if(refNum>0){
            return BaseResult.ok("删除成功！");
        }else{
            return BaseResult.error(400,"删除失败！");
        }
    }
    @PostMapping("/updateSignalCollect")
    @ApiOperation(value="修改配置信息")
    public BaseResult updateSignalCollect(@RequestBody @ApiParam(name="配置信息对象",value="id,comPort,organizationId",required = true) SignalCollectInfo signalCollectInfo){
        int refNum = signalCollectService.updateSignalCollect(signalCollectInfo);
        if(refNum>0){
            return BaseResult.ok("修改配置信息com端口："+signalCollectInfo.getComPort()+";设备ID："+signalCollectInfo.getDeviceId()+"成功");
        }else{
            return BaseResult.error(400,"修改配置信息失败!");
        }
    }
}
