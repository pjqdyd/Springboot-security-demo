package com.pjqdyd.service.impl;

import com.pjqdyd.entity.Perm;
import com.pjqdyd.mapper.PermMapper;
import com.pjqdyd.service.PermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermServiceImpl implements PermService {

    @Resource
    private PermMapper permMapper;

    /**
     * 通过用户的Id查询该用户有关的权限
     * @param userId
     * @return
     */
    @Override
    public List<Perm> selectAllByUserId(Long userId) {
        return permMapper.selectAllByUserId(userId);
    }

}
