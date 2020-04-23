package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能模块(通讯管理)
 *
 * @Author white Liu
 * @Date 2020/3/30 19:41
 * @Version 1.0
 */
@Component
public interface DeviceMapper {

    List<DeviceInfo> findDevice();

    int deleteDeviceById(DeviceInfo deviceInfo);

    int insertDevice(DeviceInfo deviceInfo);

    int updateDevice(DeviceInfo deviceInfo);

    List<DeviceInfo> deviceListBySchoolName(DeviceInfo deviceInfo);

    int deleteDeviceBySchoolId(DeviceInfo deviceInfo);
}
