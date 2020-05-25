package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.DeviceInfo;
import com.rtst.dhjc.entity.SchoolInfo;
import com.rtst.dhjc.entity.SiteInfo;
import com.rtst.dhjc.service.serviceImpl.DeviceServiceImpl;
import com.rtst.dhjc.service.serviceImpl.SchoolServiceImpl;
import com.rtst.dhjc.service.serviceImpl.SiteServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能模块(学校信息相关)
 *
 * @Author white Liu
 * @Date 2020/4/13 9:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/school")
@Api(tags = "学校信息")
public class SchoolController {
    @Autowired
    SchoolServiceImpl schoolService;
    @Autowired
    DeviceServiceImpl deviceService;
    @Autowired
    SiteServiceImpl siteService;
    /**
     * 查询学校信息列表分页
     * @return
     */
    @PostMapping("/schoolListPage")
    @ApiOperation(value="通过所属区域ID查询学校信息列表(分页)")
    public BaseResult schoolListPage(@RequestBody @ApiParam(name="学校对象",value="belongArea,pageNum,pageSize",required = true) SchoolInfo schoolInfo){
        PageHelper.startPage(schoolInfo.getPageNum(),schoolInfo.getPageSize());
        List<SchoolInfo> schoolInfoList = schoolService.findSchoolList(schoolInfo);
        PageInfo pageInfo = new PageInfo(schoolInfoList);
        return BaseResult.ok().put("data",pageInfo);
    }
    /**
     * 查询学校信息列表
     * @return
     */
    @PostMapping("/schoolList")
    @ApiOperation(value="查询所有学校信息")
    public BaseResult schoolList(@RequestBody @ApiParam(name="学校对象") SchoolInfo schoolInfo){
        List<SchoolInfo> schoolInfoList = schoolService.findSchoolList(schoolInfo);
        return BaseResult.ok().put("data",schoolInfoList);
    }
    /**
     * 添加学校信息
     * @return
     */
    @PostMapping("/addSchool")
    @ApiOperation(value="添加学校")
    public BaseResult addSchool(@RequestBody @ApiParam(name="学校对象",value="schoolName,belongArea,location,lngAndLat", required = true) SchoolInfo schoolInfo){
        int refNum = schoolService.addSchool(schoolInfo);
        if(refNum>0){
            return BaseResult.ok("添加学校"+schoolInfo.getSchoolName()+"成功");
        }else{
            return BaseResult.error(400,"添加学校失败！");
        }
    }

    /**
     * 通过ID删除学校
     * @return
     */
    @DeleteMapping("/deleteSchool")
    @ApiOperation(value="以id删除学校信息")
    public BaseResult deleteSchool(@RequestBody @ApiParam(name="学校ID",value="id",required = true) SchoolInfo schoolInfo){
        int refNum = schoolService.deleteSchool(schoolInfo);
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setSchoolId(schoolInfo.getId());
        SiteInfo siteInfo = new SiteInfo();
        siteInfo.setSchoolId(schoolInfo.getId());
        siteService.deleteSiteBySchoolId(siteInfo);
        int refNum1 = deviceService.deleteDeviceBySchoolId(deviceInfo);
        if(refNum>0 && refNum1>0){
            return BaseResult.ok("删除成功！");
        }else{
            return BaseResult.error(400,"删除失败！");
        }
    }

    /**
     * 修改学校信息
     * @return
     */
    @PostMapping("/updateSchool")
    @ApiOperation(value="修改学校信息")
    public BaseResult updateSchool(@RequestBody @ApiParam(name="学校对象",value="id,schoolName,belongArea,location,lngAndLat",required = true) SchoolInfo schoolInfo){
        int refNum = schoolService.updateSchool(schoolInfo);
        if(refNum>0){
            return BaseResult.ok("修改学校信息成功！");
        }else{
            return BaseResult.error(400,"修改学校失败！");
        }
    }
}
