package com.pjqdyd.service.impl;

import com.pjqdyd.entity.User;
import com.pjqdyd.repository.UserRepository;
import com.pjqdyd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 覆盖此方法, 给认证service中提供用户信息
     * @param s
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //(在登录时也会调用此方法,是为了获取到user的角色,提供角色认证信息,不可避免要查询一次数据库,(如果角色和用户
        // 没有关联关系, 这里就要额外查询该用户的角色, 并user.setRoles返回), 并不是为了jwt验证token查数据库,
        // 但是因为获取了数据库的用户信息, 我们就可以不仅解密token验证,还可以再和数据库的username比对, 双重验证 )
        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
