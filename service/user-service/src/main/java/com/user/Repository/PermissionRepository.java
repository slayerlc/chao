package com.user.Repository;

import com.user.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: lvchao
 * @Date: 2018-11-09 10:34
 * @Email:641819417@qq.com
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long>,JpaSpecificationExecutor<Permission>{

}
