package com.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * @Author: lvchao
 * @Date: 2018-11-08 11:33
 * @Email:641819417@qq.com
 */
@MappedSuperclass
public class BaseModel {

    @Column(name = "create_time")
    Date createTime;

    @Column(name = "update_time")
    Date updateTime;

    @PrePersist
    public void onCreate(){
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        this.updateTime = new Date();
    }
}
