### SpringBoot + Spring Security + Jwt整合实现基于RBAC角色权限的访问控制的案例

#### 初始配置:
   1. 创建一个数据库db_spring_security, 执行init_user_role_perm.sql初始建表语句
   2. 配置application.yml数据库连接信息
   3. 启动应用
   
#### 登录访问测试:
    
1. 访问接口http://localhost:8080/auth/login登录获取token:
  ```
    curl -X POST
    -H "accept: application/json" -H "content-type: application/x-www-formurlencoded" 
    -d "username=admin&password=123456" 
    'http://localhost:8080/auth/login' 
  ```
  得到到如下响应:
  ```
    {
        "code": 200,
        "message": "SUCCESS",
        "data": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE1ODc1MzQ5Njg1NTYsInBlcm1zIjoiUEVSRV9VU0VSLFBFUk1fQURNSU4iLCJleHAiOjE1OTAxMjY5Njh9.hovQS6jvgMwc2ywNs4R94GpIwX7gMkdP0cos8SvdSbYjXZRl8oaxbgrpZZRpvVTXr0aLcsrJPmfX9LJvuaq-7Q"
    }
  ```

 2. 使用token访问用户接口:
```
    curl -X GET
     -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE1ODc1MzU2NDg2ODAsInBlcm1zIjoiUEVSTV9VU0VSLFBFUk1fQURNSU4iLCJleHAiOjE1OTAxMjc2NDh9.p5Jo68_76JZ4rKMDZWPRna0wUbMPXQqPAJuLuEHf--KNaY7BnGw5B1_FKpdS5bJwtH84fXieU80PnAoGdiC3TQ"
     -H "Content-Type: application/json" 
    'http://localhost:8080/user/hello' 
```
得到如下响应,表示接口访问成功:
```
{
    "code": 200,
    "message": "SUCCESS",
    "data": "hello"
}
```
日志打印:
```
2020-04-22 14:12:39.032 INFO 13728 --- [nio-8080-exec-4] com.pjqdyd.filter.JwtTokenFilter : 检查认证信息 用户名=admin 权限=PERM_USER,PERM_ADMIN 访问接口=/user/hello
```

#### 提示:

   1.项目ORM框架使用的是Mybatis.
   
   2.数据库中有5张表, 分别是用户表, 角色表, 权限表, 用户关联角色表, 角色关联权限表
     对应tb_user, tb_role, tb_perm, tb_user_roles, tb_role_perms.
     
   2.本项目采用的是将用户的权限信息保存在JWT的token载荷中, 访问接口时解析token中的权限信息
   交由SpringSecurity进行访问控制, 减少了频繁从数据库获取用户权限, 真正做到了高效率无状态,
   
   缺点就是token一旦签发出去, 在过期时间内就是不可控的, 如果系统对安全性要求高, 可以选择每次
   访问接口从数据库中查询用户的权限, 增加安全性,降低一点性能
   


