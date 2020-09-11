package com.rtst.dhjc.entity;

import lombok.Data;

/**
 * 功能模块(组织信息)
 *
 * @Author white Liu
 * @Date 2020/3/30 18:41
 * @Version 1.0
 */
@Data
public class OrganizationInfo {
    private int id;//组织ID
    private String organizationName;//组织名称
    private int belongArea;//组织所属区域id
    private String location;//组织位置详情
    private String lngAndLat;//组织位置经纬度
    private int pageNum;//页数
    private int pageSize;
}
