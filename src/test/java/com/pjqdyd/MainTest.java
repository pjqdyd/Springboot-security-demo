package com.pjqdyd;

import com.pjqdyd.entity.Permission;
import com.pjqdyd.entity.Role;
import com.pjqdyd.entity.User;
import com.pjqdyd.repository.PermissionRepository;
import com.pjqdyd.repository.RoleRepository;
import com.pjqdyd.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MainTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    /**
     * 添加用户测试
     */
    @Test
    public void addUserTest(){
        User user = new User();
        user.setUsername("pjqdyd");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setAge(18);

        User result = userRepository.save(user);

        System.out.println(result.toString());
        Assert.assertNotNull(result);
    }

    /**
     * 添加角色测试
     */
    @Test
    public void addRoleTest(){
        Role role = new Role();
        role.setRoleId(1003);
        role.setRoleName("ROLE_SUPER_ADMIN");
        role.setRoleNameCn("超级管理员角色");

        Role result = roleRepository.save(role);
        System.out.println(result.toString());
        Assert.assertNotNull(result);
    }

    /**
     * 添加权限测试
     */
    @Test
    public void addPermissionTest(){

        Permission permission = new Permission();
        permission.setPermissionId(2004);
        permission.setPermissionName("PERM_DELETE");
        permission.setPermissionNameCn("删除权限");

        Permission result = permissionRepository.save(permission);

        System.out.println(result.toString());
        Assert.assertNotNull(result);
    }

    /**
     * 用户关联角色测试
     */
    @Test
    public void userRole(){

        User user = userRepository.findByUsername("pjqdyd");

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByRoleNameCn("用户角色"));

        user.setRoles(roles);

        User result = userRepository.save(user);

        System.out.println(result.toString());
        Assert.assertNotNull(result);
    }

}
