package com.message.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * @Author: lvchao
 * @Date: 2018-08-02 17:37
 */

@Entity
@Table(name = "dec_construction_site")
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
public class DecConstructionSite {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "sharding_id")
    private String shardingId;

    @Column(name = "sharding_name")
    private String shardingName;

    @Column(name = "dictItem_code")
    private String dictItemCode;

    @Column(name = "dictItem_value")
    private String dictItemValue;

    @Column(name = "base_name")
    private String baseName;

    @Column(name = "ban")
    private String ban;

    @Column(name = "unit")
    private String unit;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "dec_shop_phone_number")
    private String decShopPhoneNumber;

    @Column(name = "foreman_phone_number")
    private String foremanPhoneNumber;

    @Column(name = "designer_phone_number")
    private String designerPhoneNumber;

    @Column(name = "gmt_created")
    private Date gmtCreated;

    @Column(name = "gmt_modified")
    private Date gmtModified;

}