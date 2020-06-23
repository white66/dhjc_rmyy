package com.rtst.dhjc.entity;

import lombok.Data;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/6/4 14:21
 * @Version 1.0
 */
@Data
public class EnergyInfo {
    private Integer id;
    private Float energyValue;//能耗值
    private String sigCode;//参数码
    private String dateTime;//时间日期
    private String startTime;//开始时间
    private String endTime;//结束时间
    private int type;//区分是按年月日来查询能耗值
    private String sIG_Name;//参数名
}
