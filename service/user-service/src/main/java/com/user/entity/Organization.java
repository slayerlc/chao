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
 * @Date: 2018-11-08 15:14
 * @Email:641819417@qq.com
 */
@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "organization")
public class Organization extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "org_sign")
    String orgSign;

    @Column(name = "org_name")
    String orgName;

    @Column(name = "description")
    String description;

    //自关联 一对一   这个和下面那个 同时打开会 json序列化循环引用
    /*@OneToOne()
    @JoinColumn(name = "org_parent",referencedColumnName = "id")
    Organization orgParent;*/

    //自关联 一对多 查所有子部门
    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "org_parent")
    Set<Organization> organizationSet;*/

    @Column(name = "org_parent")
    Long orgParent;

    @ManyToMany(mappedBy = "organizationSet",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("organizationSet")
    Set<User> userSet;

    @ManyToMany(mappedBy = "organizationSet",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("organizationSet")
    Set<Role> roleSet;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "permission_org",
            joinColumns = {@JoinColumn(name = "org_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    @JsonIgnoreProperties("organizationSet")
    Set<Permission> permissionSet;

}
