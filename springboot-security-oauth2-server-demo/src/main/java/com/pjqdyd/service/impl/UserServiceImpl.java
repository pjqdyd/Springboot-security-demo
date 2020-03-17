package com.pjqdyd.service.impl;

import com.pjqdyd.domain.User;
import com.pjqdyd.repository.UserRepository;
import com.pjqdyd.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**   
 * @Description:  [用户服务实现]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User getUserByName(String username) {
        return userRepository.findByUsername(username);
    }
}
