package com.rtst.dhjc.entity;

import lombok.Data;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/5/19 11:46
 * @Version 1.0
 */
@Data
public class SiteInfo {
    private Integer organizationId;//组织ID
    private Integer siteId;//机房ID
    private String siteName;//机房名
    private String organizationName;//组织名
}
