package com.pjqdyd.enums;

import lombok.Getter;

/**   
 * @Description:  [用户角色枚举]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Getter
public enum RoleEnum {

    ROLE_ADMIN(1001, "ROLE_USER", "用户角色"),
    ROLE_USER(1002, "ROLE_ADMIN", "管理员角色"),
    ROLE_SUPER_ADMIN(1003, "ROLE_SUPER_ADMIN", "超级管理员角色");

    private Integer roleId;

    private String roleName;

    private String roleNameCN;

    RoleEnum(Integer roleId, String roleName, String roleNameCN){
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleNameCN = roleNameCN;
    }
}
