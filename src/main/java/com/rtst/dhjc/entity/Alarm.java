package com.rtst.dhjc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 功能模块(告警实体类)
 *
 * @Author white Liu
 * @Date 2020/6/28 8:55
 * @Version 1.0
 */
@Data
public class Alarm {
    private Integer warn_Id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date warn_DateTime;//报警时间
    private String warn_Content;//报警信息
    private Integer organizationId;//学校ID
    private String warn_SIG_Code;//参数码
    private String startTime;//开始时间
    private String endTime;//结束时间
    private int pageNum;
    private int pageSiZe;
}
