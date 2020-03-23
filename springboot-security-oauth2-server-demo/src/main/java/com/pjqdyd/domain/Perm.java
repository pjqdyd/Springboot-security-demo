package com.pjqdyd.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_perm")
public class Perm {

    @Id
    private Integer permId;

    private String permName;

    private String permNameCn;
}