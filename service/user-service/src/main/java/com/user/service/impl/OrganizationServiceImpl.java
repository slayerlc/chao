package com.user.service.impl;

import com.user.Repository.OrganizationRepository;
import com.user.entity.Organization;
import com.user.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: lvchao
 * @Date: 2018-11-09 9:40
 * @Email:641819417@qq.com
 */
@Slf4j
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
}
