#### Springboot + Security oauth2整合的基于角色权限认证模块

(密码模式: 直接输入用户名密码获取access_token, 与授权码模式不同, 
 密码模式适合自己公司的服务之间使用)

1. 先配置好数据库连接, 创建数据库db_spring_security_oauth2

2. 执行security oauth2官方提供的初始的建表schema.sql语句

3. 先初始一个认证客户,在表oauth_client_details中增加一条客户:
```
INSERT INTO 
`oauth_client_details`
 (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`)
 VALUES 
 ('client', '$2a$10$RcCCUjMkLVfVwLnvfQpEfO3xCXf2nDshl0tlL29MvKTrdeiolCmfi', 'app', 'password', '');
```

```
client_id：客户端标识
client_secret：客户端安全码，此处不能是明文，
               需要加密(System.out.println(new BCryptPasswordEncoder().encode("secret"));)
scope：客户端授权范围
authorized_grant_types：客户端授权类型
web_server_redirect_uri：服务器回调地址
```

4. 执行init_user_role_perm.sql初始自定义的用户信息表, 初始两个用户角色的信息(admin, user),密码都为123456

5. 启动项目, 使用postman发送如下请求:
```
curl -X POST
-H "accept: application/json" -H "content-type: application/x-www-formurlencoded" 
-d "grant_type=password&username=admin&password=123456&scope=app" 
'http://client:secret@localhost:9000/oauth/token' 
```