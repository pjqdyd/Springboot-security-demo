package com.pjqdyd.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**   
 * @Description:  [权限实体类]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */
@Data
@Entity
@Table(name = "tb_permission")
@ToString(exclude = "roles")
public class Permission {

    /**
     *权限Id
     */
    @Id
    private Integer permissionId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限名称中文
     */
    private String permissionNameCn;

    /**
     * 权限关联角色, 权限放弃维护权, 由role角色管理,role主导
     */
    @ManyToMany(mappedBy = "permissions",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Role> roles;

}
