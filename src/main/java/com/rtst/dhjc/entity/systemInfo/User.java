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

    private Integer  schoolId;//绑定的学校ID

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date expiredDate;//到期时间

    private String name;//用户名

    private String passWord;//密码

    private String salt;//盐值

    private Integer state;//用户状态

    private String userName;//登录名

    private String phone;//手机号

    private String remarks;//备注

    /**
     * 密码盐. 重新对盐重新进行了定义，用户名+salt，这样就不容易被破解，可以采用多种方式定义加盐
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.userName + this.salt;
    }
}
