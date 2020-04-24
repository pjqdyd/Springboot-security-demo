package com.pjqdyd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Long userId;

    @Column(name = "`password`")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "mail")
    private String mail;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    private static final long serialVersionUID = 1L;
}