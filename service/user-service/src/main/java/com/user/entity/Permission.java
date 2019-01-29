package com.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @Author: lvchao
 * @Date: 2018-11-08 15:11
 * @Email:641819417@qq.com
 */
@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Table(name = "permission")
public class Permission extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "permission_sign")
    @NotBlank(message = "权限标识不能为空!")
    String permissionSign;

    @Column(name = "permission_name")
    String permissionName;

    @Column(name = "permission_url")
    String permissionUrl;

    @Column(name = "authc_mode")
    String authcMode;

    @Column(name = "description")
    String description;

    /*@ManyToMany(mappedBy = "permissionSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("permissionSet")
    Set<Organization> organizationSet;

    @ManyToMany(mappedBy = "permissionSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("permissionSet")
    Set<User> userSet;

    @ManyToMany(mappedBy = "permissionSet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("permissionSet")
    Set<Role> roleSet;*/

}
