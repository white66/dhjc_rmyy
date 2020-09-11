package com.rtst.dhjc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author white Liu
 * @Date 2019/12/10 9:51
 * @Version 1.0
 */
@Data
public class Signal implements Serializable {
    private int sIG_ID;
    private String sIG_Code;//编号
    private String sIG_Name;//信号名称
    private String sigUnit;//信号单位
    private String sIG_Type;//信号类型
    private String sIG_FAC_ID;//信号设备编号
    private int sIG_Address;//寄存器开始地址
    private int sIG_AddressNum;//地址个数
    private String sIG_DataType;//数据类型
    private String dSIG_Value;//信号值
    private String dsigDateTime;//采集时间
    private int organizationId;//采集信息关联组织ID
    private int sIG_State;//是否启用 0 未启用 1启用
    private int flag;//区分模块的标识
    private int typeFlag;//区分参数类型
    private int pageNum;//页数
    private int pageSize;
    private int alarmState;//该参数值是否达到告警值
    private String startTime;
    private String endTime;
    private Integer startTypeFlag;
    private Integer endTypeFlag;
}
