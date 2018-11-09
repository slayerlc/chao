package com.user.Repository;

import com.user.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: lvchao
 * @Date: 2018-11-09 9:38
 * @Email:641819417@qq.com
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long>,JpaSpecificationExecutor<Organization>{
}
