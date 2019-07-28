package com.pjqdyd.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**   
 * @Description:  [角色实体类, 实现GrantedAuthority接口, 并覆盖getAuthority方法返回角色名]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Data
@Entity
@Table(name = "tb_role")
@ToString(exclude = "users")
public class Role implements GrantedAuthority {

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
     * 角色关联用户, 角色放弃控制权,交给user维护,user具有主导权, 用户懒加载
     */
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    /**
     * 给认证用户提供角色名
     */
    @Override
    public String getAuthority() {
        return roleName;
    }
}
