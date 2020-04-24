package com.pjqdyd.enums;

import lombok.Getter;

/**   
 * @Description:  [角色权限枚举]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Getter
public enum PermEnum {

    PERM_SUPER_ADMIN(1001, "PERM_SUPER_ADMIN", "超级管理员权限"),
    PERM_ADMIN(1002, "PERM_ADMIN", "管理员权限"),
    PERM_USER(1003, "PERM_USER", "用户权限");

    private Integer permId;

    private String permName;

    private String permNameCN;

    PermEnum(Integer permId, String permName, String permNameCN){
        this.permId = permId;
        this.permName = permName;
        this.permNameCN = permNameCN;
    }

}
