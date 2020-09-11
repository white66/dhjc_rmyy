package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.DeviceInfo;
import com.rtst.dhjc.entity.SignalCollectInfo;
import com.rtst.dhjc.service.serviceImpl.DeviceServiceImpl;
import com.rtst.dhjc.service.serviceImpl.SignalCollectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "设备管理")
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
    @ApiOperation(value = "查询设备信息列表（分页）")
    public BaseResult deviceList(@RequestBody @ApiParam(name = "页码pageNum，行数pagesize" ,value="pageNum,pageSize", required = true) DeviceInfo deviceInfo){
        PageHelper.startPage(deviceInfo.getPageNum(),deviceInfo.getPageSize());
        List<DeviceInfo> deviceInfoList = deviceService.findDevice();
        PageInfo pageInfo = new PageInfo(deviceInfoList);
        return BaseResult.ok().put("data",pageInfo);
    }

    /**
     * 通过组织名查询设备信息
     * @param deviceInfo
     * @return
     */
    @PostMapping("/deviceListByOrganizationName")
    @ApiOperation(value = "通过学校名查询下属设备信息")
    public BaseResult deviceListByOrganizationName(@RequestBody @ApiParam(name = "设备对象",value = "organizationName,pageNum,pageSize",required = true) DeviceInfo deviceInfo){
        PageHelper.startPage(deviceInfo.getPageNum(),deviceInfo.getPageSize());
        List<DeviceInfo> deviceInfoList = deviceService.deviceListByOrganizationName(deviceInfo);
        PageInfo pageInfo = new PageInfo(deviceInfoList);
        return BaseResult.ok().put("data",pageInfo);
    }
    /**
     * 删除通讯管理机
     * @param deviceInfo
     * @return
     */
    @DeleteMapping("/deleteDevice")
    @ApiOperation(value = "通过ID删除设备信息")
    public BaseResult deleteDeviceById(@RequestBody @ApiParam(name = "设备ID",value = "id",required = true) DeviceInfo deviceInfo){
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
    @ApiOperation(value = "添加设备信息")
    public BaseResult insertDevice(@RequestBody @ApiParam(name="设备对象",value = "id,deviceName,organizationId",required = true) DeviceInfo deviceInfo){
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
    @ApiOperation(value = "修改设备信息")
    public BaseResult updateDevice(@RequestBody @ApiParam(name="设备信息对象",value="id,deviceName,organizationId",required = true) DeviceInfo deviceInfo){
        int refNum = deviceService.updateDevice(deviceInfo);
        if(refNum==0){
            return  BaseResult.error(400,"修改失败！");
        }else{
            return BaseResult.ok("修改通讯管理机成功！");
        }
    }

}
