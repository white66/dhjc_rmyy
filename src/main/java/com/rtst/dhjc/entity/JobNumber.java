package com.rtst.dhjc.entity;

import lombok.Data;

/**
 * @Author White Liu
 * @Description 工号实体类，用于向webservice接口发送请求
 * @Date 2020/10/13 11:14
 * @Version 1.0
 */
@Data
public class JobNumber {
    private Integer id;
    private String jobNumber;//工号
}
