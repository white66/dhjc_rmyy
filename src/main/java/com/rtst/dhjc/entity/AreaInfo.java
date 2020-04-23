package com.rtst.dhjc.entity;

import lombok.Data;

/**
 * 功能模块(区域信息实体类)
 *
 * @Author white Liu
 * @Date 2020/4/1 19:08
 * @Version 1.0
 */
@Data
public class AreaInfo {
    private int id;//区域id
    private int parentId;//所属上级区域id
    private String areaName;//区域名称
}
