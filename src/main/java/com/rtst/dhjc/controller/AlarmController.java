package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.Alarm;
import com.rtst.dhjc.service.serviceImpl.AlarmServiceImpl;
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
 * 功能模块(告警功能)
 *
 * @Author white Liu
 * @Date 2020/6/28 8:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/alarm")
@Api(tags = "告警信息")
public class AlarmController {
    @Autowired
    AlarmServiceImpl alarmService;
    @PostMapping("/alarmList")
    @ApiOperation(value = "查询历史告警信息（分页）")
    public BaseResult alarmList(@RequestBody @ApiParam(name="开始时间，结束时间,页码，行数",value="startTime,endTime，pageNum,pageSize",required = true) Alarm alarm){
        PageHelper.startPage(alarm.getPageNum(),alarm.getPageSiZe());
        List<Alarm> alarms = alarmService.alarmList(alarm);
        PageInfo<Alarm> alarmPageInfo = new PageInfo<>(alarms);
        return BaseResult.ok().put("data",alarmPageInfo);
    }
}
