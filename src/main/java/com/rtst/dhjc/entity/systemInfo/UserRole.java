package com.rtst.dhjc.entity.systemInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @since 2020-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer userId;//用户ID

    private Integer roleId;//角色ID


}
