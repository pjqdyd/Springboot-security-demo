package com.pjqdyd.service.impl;

import com.pjqdyd.entity.User;
import com.pjqdyd.mapper.UserMapper;
import com.pjqdyd.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByName(String username) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", username);
        return userMapper.selectOneByExample(example);
    }
}
