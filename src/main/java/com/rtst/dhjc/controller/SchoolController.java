package com.rtst.dhjc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.DeviceInfo;
import com.rtst.dhjc.entity.SchoolInfo;
import com.rtst.dhjc.service.serviceImpl.DeviceServiceImpl;
import com.rtst.dhjc.service.serviceImpl.SchoolServiceImpl;
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
public class SchoolController {
    @Autowired
    SchoolServiceImpl schoolService;
    @Autowired
    DeviceServiceImpl deviceService;
    /**
     * 查询学校信息列表分页
     * @return
     */
    @PostMapping("/schoolListPage")
    public BaseResult schoolListPage(@RequestBody SchoolInfo schoolInfo){
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
    public BaseResult schoolList(@RequestBody SchoolInfo schoolInfo){
        List<SchoolInfo> schoolInfoList = schoolService.findSchoolList(schoolInfo);
        return BaseResult.ok().put("data",schoolInfoList);
    }
    /**
     * 添加学校信息
     * @return
     */
    @PostMapping("/addSchool")
    public BaseResult addSchool(@RequestBody SchoolInfo schoolInfo){
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
    public BaseResult deleteSchool(@RequestBody SchoolInfo schoolInfo){
        int refNum = schoolService.deleteSchool(schoolInfo);
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setSchoolId(schoolInfo.getId());
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
    public BaseResult updateSchool(@RequestBody SchoolInfo schoolInfo){
        int refNum = schoolService.updateSchool(schoolInfo);
        if(refNum>0){
            return BaseResult.ok("修改学校信息成功！");
        }else{
            return BaseResult.error(400,"修改学校失败！");
        }
    }

}
