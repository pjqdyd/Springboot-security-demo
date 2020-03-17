package com.pjqdyd.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**   
 * @Description:  [用户实体类, 实现security的UserDetails,并覆盖其中的方法(为了提供用户角色权限信息)]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */
@Data
@Entity
@Table(name = "tb_user")
@ToString(exclude = "rolos")
public class User implements UserDetails {

    /**
     *userId自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 用户名
     */
    @Column(unique = true)
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 用户关联角色, 角色急加载 (防止获取多方的时候session已经关闭了，这时候会获取不到多方信息，因此要急加载)
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    //返回分配给用户的角色列表集合
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    //账户是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //账户是否锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //密码是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //账户是否激活
    @Override
    public boolean isEnabled() {
        return true;
    }

}
