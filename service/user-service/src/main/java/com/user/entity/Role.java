package com.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.modle.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author: lvchao
 * @Date: 2018-11-08 11:32
 * @Email:641819417@qq.com
 */
@Entity
@Getter
@Setter
@Table(name = "role")
@DynamicInsert
@DynamicUpdate
public class Role extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "role_sign")
    String roleSign;

    @Column(name = "role_name")
    String roleName;

    @Column(name = "description")
    String description;

    @ManyToMany(mappedBy = "roleSet",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("roleSet")
    Set<User> userSet;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "role_org",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "org_id", referencedColumnName = "id")}
    )
    @JsonIgnoreProperties("roleSet")
    Set<Organization> organizationSet;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    @JsonIgnoreProperties("roleSet")
    Set<Permission> permissionSet;
}
