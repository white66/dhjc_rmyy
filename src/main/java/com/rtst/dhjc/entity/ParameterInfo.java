package com.rtst.dhjc.entity;

import lombok.Data;

/**
 * 功能模块(配置参数实体类)
 *
 * @Author white Liu
 * @Date 2020/5/6 11:21
 * @Version 1.0
 */
@Data
public class ParameterInfo {
    private Integer id;
    private String sIG_Dcode;//配置参数ID
    private String sIG_Dname;//配置参数名
}
