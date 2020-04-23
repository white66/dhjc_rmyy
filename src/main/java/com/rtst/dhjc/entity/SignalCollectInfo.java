package com.rtst.dhjc.entity;

import lombok.Data;

/**
 * 功能模块(信号采集配置类)
 *
 * @Author white Liu
 * @Date 2020/4/13 10:03
 * @Version 1.0
 */
@Data
public class SignalCollectInfo {
    private int id;
    private int comPort;//COM端口号
    private int deviceId;//设备ID
    private String deviceName;//设备名称
    private int pageNum;
    private int pageSize;
}
