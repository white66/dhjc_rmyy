package com.rtst.dhjc.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class CacheUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer organizationId;

    private Integer state;

    private String userName;

    private String token;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date expiredDate;//过期时间
    private Integer roleId;//角色ID
}
