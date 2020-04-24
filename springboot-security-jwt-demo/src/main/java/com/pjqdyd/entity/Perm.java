package com.pjqdyd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "tb_perm")
public class Perm implements Serializable {
    @Id
    @Column(name = "perm_id")
    private Integer permId;

    @Column(name = "perm_name")
    private String permName;

    @Column(name = "perm_name_cn")
    private String permNameCn;

    private static final long serialVersionUID = 1L;
}