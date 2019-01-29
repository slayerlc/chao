package com.model;

import javax.persistence.*;

/**
 * @Author: lvchao
 * @Date: 2018-11-07 9:54
 * @Email:641819417@qq.com
 */
@MappedSuperclass
public class IsDeleteModel extends BaseModel{

    @Column(name = "is_delete")
     Boolean isDelete = false;
}
