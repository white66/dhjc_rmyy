package com.rtst.dhjc.entity;

import lombok.Data;

/**
 * 功能模块(学校信息)
 *
 * @Author white Liu
 * @Date 2020/3/30 18:41
 * @Version 1.0
 */
@Data
public class SchoolInfo {
    private int id;//学校ID
    private String schoolName;//学校名称
    private int belongArea;//学校所属区域id
    private String location;//学校位置详情
    private String lngAndLat;//学校位置经纬度
    private int pageNum;//页数
    private int pageSize;
}
