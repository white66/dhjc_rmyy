package com.rtst.dhjc.entity.systemInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author White Liu
 * @since 2020-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer permissionId;//权限ID


    private String filePath;//文件路径


    private Long parentId;//父ID


    private String id;//ID


    private String permission;//权限


    private String permissionName;//权限名


    private String resourceType;//类型

    private String url;//url路径
    private int state;//状态值
    private String iconPath;//图标路径

}
