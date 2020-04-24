package com.pjqdyd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "tb_role")
public class Role implements Serializable {
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_name_cn")
    private String roleNameCn;

    private static final long serialVersionUID = 1L;
}