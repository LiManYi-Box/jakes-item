package com.leader.provider.api.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_jackrisk_user")
public class TbJackriskUser implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码，加密存储
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 注册手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 注册邮箱
     */
    @Column(name = "email")
    private String email;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;

    /**
     * 状态(0/1)0可用，1不可用
     */
    @Column(name = "states")
    private Integer states;

    private static final long serialVersionUID = 1L;
}