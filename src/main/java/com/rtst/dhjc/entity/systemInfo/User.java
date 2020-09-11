package com.rtst.dhjc.entity.systemInfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *用户实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;//用户ID

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;//用户注册时间

    private Integer  organizationId;//绑定的组织ID

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date expiredDate;//到期时间

    private String passWord;//密码

    private Integer state;//用户状态
    private String email;//邮箱
    private String userName;//登录名
    private Integer pageNum;
    private Integer pageSize;
}
