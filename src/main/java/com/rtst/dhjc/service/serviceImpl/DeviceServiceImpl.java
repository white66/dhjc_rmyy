package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.DeviceInfo;
import com.rtst.dhjc.repository.DeviceMapper;
import com.rtst.dhjc.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能模块(通讯管理)
 *
 * @Author white Liu
 * @Date 2020/3/30 19:33
 * @Version 1.0
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;


    public List<DeviceInfo> findDevice() {
        List<DeviceInfo> deviceInfos = deviceMapper.findDevice();
        return deviceInfos;
    }

    @Override
    public int deleteDeviceById(DeviceInfo deviceInfo) {
        int refNum = deviceMapper.deleteDeviceById(deviceInfo);
        return refNum;
    }

    @Override
    public int insertDevice(DeviceInfo deviceInfo) {
        int refNum = deviceMapper.insertDevice(deviceInfo);
        return refNum;
    }

    @Override
    public int updateDevice(DeviceInfo deviceInfo) {
        int refNum = deviceMapper.updateDevice(deviceInfo);
        return refNum;
    }

    @Override
    public List<DeviceInfo> deviceListByOrganizationName(DeviceInfo deviceInfo) {
        List<DeviceInfo> deviceInfoList = deviceMapper.deviceListByOrganizationName(deviceInfo);
        return deviceInfoList;
    }

    @Override
    public int deleteDeviceByOrganizationId(DeviceInfo deviceInfo) {
        int refNum = deviceMapper.deleteDeviceByOrganizationId(deviceInfo);
        return refNum;
    }
}
