package com.rtst.dhjc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/5/7 10:54
 * @Version 1.0
 */
@Data
public class SignalVo implements Serializable {
    private int sIG_ID;
    private int sIG_State;//是否启用 0 未启用 1启用
}
