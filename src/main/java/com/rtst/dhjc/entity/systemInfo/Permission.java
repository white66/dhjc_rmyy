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


    private Integer permissionId;


    private Boolean available;


    private Long parentId;


    private String id;


    private String permission;


    private String permissionName;


    private String resourceType;

    private String url;
    private int state;


}
