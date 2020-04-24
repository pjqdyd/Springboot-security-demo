package com.pjqdyd.service.impl;

import com.pjqdyd.mapper.RoleMapper;
import com.pjqdyd.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

}
