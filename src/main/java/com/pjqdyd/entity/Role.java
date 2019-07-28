package com.pjqdyd.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**   
 * @Description:  [角色实体类]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Data
@Entity
@Table(name = "tb_role")
@ToString(exclude = {"users", "permissions"})
public class Role {

    /**
     * 角色Id
     */
    @Id
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色名称中文
     */
    private String roleNameCn;

    /**
     * 角色关联用户, 角色放弃控制权,交给user维护,user具有主导权
     */
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    /**
     * 角色关联权限
     */
    @ManyToMany
    private List<Permission> permissions;

}
