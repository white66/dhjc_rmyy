package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.DeviceInfo;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/3/30 19:40
 * @Version 1.0
 */
public interface DeviceService {
    List<DeviceInfo> findDevice();

    int deleteDeviceById(DeviceInfo deviceInfo);

    int insertDevice(DeviceInfo deviceInfo);

    int updateDevice(DeviceInfo deviceInfo);

    List<DeviceInfo> deviceListBySchoolName(DeviceInfo deviceInfo);

    int deleteDeviceBySchoolId(DeviceInfo deviceInfo);
}
