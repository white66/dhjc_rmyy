package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.DeviceInfo;
import com.rtst.dhjc.entity.SignalCollectInfo;
import com.rtst.dhjc.service.serviceImpl.DeviceServiceImpl;
import com.rtst.dhjc.service.serviceImpl.SignalCollectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能模块(通讯管理)
 *
 * @Author white Liu
 * @Date 2020/3/30 19:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/device")
public class DeviceController {
    @Autowired
    DeviceServiceImpl deviceService;
    @Autowired
    SignalCollectServiceImpl signalCollectService;
    /**
     * 查询通讯管理信息列表分页
     * @return
     */
    @PostMapping("/deviceList")
    public BaseResult deviceList(@RequestBody DeviceInfo deviceInfo){
        PageHelper.startPage(deviceInfo.getPageNum(),deviceInfo.getPageSize());
        List<DeviceInfo> deviceInfoList = deviceService.findDevice();
        PageInfo pageInfo = new PageInfo(deviceInfoList);
        return BaseResult.ok().put("data",pageInfo);
    }

    /**
     * 通过学校名查询设备信息
     * @param deviceInfo
     * @return
     */
    @PostMapping("/deviceListBySchoolName")
    public BaseResult deviceListBySchoolName(@RequestBody DeviceInfo deviceInfo){
        PageHelper.startPage(deviceInfo.getPageNum(),deviceInfo.getPageSize());
        List<DeviceInfo> deviceInfoList = deviceService.deviceListBySchoolName(deviceInfo);
        PageInfo pageInfo = new PageInfo(deviceInfoList);
        return BaseResult.ok().put("data",pageInfo);
    }
    /**
     * 删除通讯管理机
     * @param deviceInfo
     * @return
     */
    @DeleteMapping("/deleteDevice")
    public BaseResult deleteDeviceById(@RequestBody DeviceInfo deviceInfo){
        int refNum = deviceService.deleteDeviceById(deviceInfo);
        SignalCollectInfo signalCollectInfo = new SignalCollectInfo();
        signalCollectInfo.setDeviceId(deviceInfo.getId());
        int refNum1 = signalCollectService.deleteSignalByDeviceId(signalCollectInfo);
        if(refNum==0 && refNum1 ==0){
            return  BaseResult.error(400,"删除失败！");
        }else{
            return BaseResult.ok("删除通讯管理机id:"+deviceInfo.getId()+"成功！");
        }
    }

    /**
     * 添加通讯管理机
     * @param deviceInfo
     * @return
     */
    @PostMapping("/addDevice")
    public BaseResult insertDevice(@RequestBody DeviceInfo deviceInfo){
        int refNum = deviceService.insertDevice(deviceInfo);
        if(refNum==0){
            return  BaseResult.error(400,"添加失败！");
        }else{
            return BaseResult.ok("添加通讯管理机"+deviceInfo.getDeviceName()+"成功！");
        }

    }

    /**
     * 修改通讯管理机信息
     * @param deviceInfo
     * @return
     */
    @PostMapping("/updateDevice")
    public BaseResult updateDevice(@RequestBody DeviceInfo deviceInfo){
        int refNum = deviceService.updateDevice(deviceInfo);
        if(refNum==0){
            return  BaseResult.error(400,"修改失败！");
        }else{
            return BaseResult.ok("修改通讯管理机成功！");
        }
    }

}
