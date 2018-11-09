package com.modle;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

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
