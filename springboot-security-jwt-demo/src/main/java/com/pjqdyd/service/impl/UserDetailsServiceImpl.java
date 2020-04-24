package com.pjqdyd.service.impl;

import com.pjqdyd.entity.Perm;
import com.pjqdyd.service.PermService;
import com.pjqdyd.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**   
 * @Description:  [用户详情服务实现, 提供用户数据给Spring security, 方便认证授权]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;

    @Resource
    private PermService permService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.pjqdyd.entity.User user = userService.getUserByName(s); //查询用户
        if(user != null){
            //查询用户的权限列表
            List<Perm> permList = permService.selectAllByUserId(user.getUserId());
            List<String> permNameList =  permList.stream().map(perm -> perm.getPermName()).collect(Collectors.toList());;
            //新返回一个userDetails的用户对象, 交由security验证
            return new User(user.getUsername(), user.getPassword(), getGrantedAuthoritiesList(permNameList));
        }

        return null;
    }

    /**
     * 根据权限名称集合创建权限认证集合, 方便提供给Security认证
     * @param permNameList 权限名称集合
     * @return
     */
    public List<GrantedAuthority> getGrantedAuthoritiesList(List<String> permNameList){
        List<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>(); //创建认证权限集合
        permNameList.forEach(permName -> {
            //获取用户的权限名permName, 创建grantedAuthority认证权限对象
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permName);
            //添加到认证权限集合中
            grantedAuthoritiesList.add(grantedAuthority);
        });
        return grantedAuthoritiesList;
    }

}
