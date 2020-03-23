package com.pjqdyd.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_role")
public class Role {
    @Id
    private Integer roleId;

    private String roleName;

    private String roleNameCn;
}