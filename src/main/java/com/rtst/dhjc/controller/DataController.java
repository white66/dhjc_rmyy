package com.rtst.dhjc.controller;

import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.EnergyInfo;
import com.rtst.dhjc.service.serviceImpl.DataServiceImpl;
import com.rtst.dhjc.service.serviceImpl.ParameterServiceImpl;
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
 * 功能模块(电能能耗值统计报表)
 *
 * @Author white Liu
 * @Date 2020/6/4 11:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/energy")
@Api(tags = "能耗值报表")
public class DataController {
    @Autowired
    DataServiceImpl dataService;
    @Autowired
    ParameterServiceImpl parameterService;
    @PostMapping("/energyList")
    @ApiOperation(value = "能耗值详情")
    public BaseResult energyList(@RequestBody @ApiParam(name="开始时间，截止时间,类型",value = "startTime,endTime,type") EnergyInfo energyInfo){
        List<EnergyInfo> energyDayList = dataService.energyList(energyInfo);
        int paramNum = parameterService.findEnergyParam();
        return BaseResult.ok().put("data",energyDayList).put("paramNum",paramNum);
    }
}
