package com.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.modle.IsDeleteModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * @Author: lvchao
 * @Date: 2018-11-07 9:46
 * @Email:641819417@qq.com
 */
@Entity
@Getter
@Setter
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
public class User extends IsDeleteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "account")
    @Size(min = 6, max = 16, message = "账号长度只能在6-16个字符之间!")
    @NotBlank(message = "账号名称不能为空!")
    String account;

    @Column(name = "salt")
    String salt;

    @Column(name = "password")
    @Size(min = 6, message = "密码长度不能小于6个字符!")
    @NotBlank(message = "密码不能为空!")
    String password;

    @Column(name = "nickname")
    @Size(min = 1, max = 16, message = "昵称长度只能在1-16个字符之间")
    @NotBlank(message = "昵称不能为空!")
    String nickName;

    @Column(name = "real_name")
    @Size(min = 1, max = 16, message = "姓名长度只能在1-16个字符之间")
    String realName;

    @Column(name = "age")
    Integer age;

    @Column(name = "gender")
    Integer gender;

    @Column(name = "phone")
    @Size(min = 11, max = 11, message = "电话长度必须是11位!")
    @NotBlank(message = "电话不能为空!")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date birthday;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "user_org",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "org_id", referencedColumnName = "id")}
    )
    @JsonIgnoreProperties("userSet")
    Set<Organization> organizationSet;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    @JsonIgnoreProperties("userSet")
    Set<Role> roleSet;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "user_permission",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    @JsonIgnoreProperties("userSet")
    Set<Permission> permissionSet;
}
