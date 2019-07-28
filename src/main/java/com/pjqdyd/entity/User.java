package com.pjqdyd.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**   
 * @Description:  [用户实体类]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */
@Data
@Entity
@Table(name = "tb_user")
@ToString(exclude = "rolos")
public class User {

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
     * 用户关联角色
     */
    @ManyToMany
    private List<Role> roles;

}
