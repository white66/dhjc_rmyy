package com.rtst.dhjc.entity;

import lombok.Data;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/3/30 19:26
 * @Version 1.0
 */
@Data
public class DeviceInfo {
    private int id;//通讯管理机id
    private String deviceName;//通讯管理机名称
    private int organizationId;//所对应的组织id
    private String organizationName;//组织名称
    private int pageNum;//页数
    private int pageSize;
}
