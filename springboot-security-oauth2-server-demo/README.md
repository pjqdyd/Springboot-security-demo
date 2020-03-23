#### Springboot + Security oauth2整合的基于角色权限认证模块

(密码模式: 直接输入用户名密码获取access_token, 与授权码模式不同, 
 密码模式适合自己公司的前后端分离的服务之间使用)

1. 先配置好数据库连接, 创建数据库db_spring_security_oauth2

2. 执行security oauth2官方提供的初始的建表schema.sql语句

3. 先初始一个认证客户,在表oauth_client_details中增加一条客户:
```
INSERT INTO 
`oauth_client_details`
 (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`)
 VALUES 
 ('client', '$2a$10$RcCCUjMkLVfVwLnvfQpEfO3xCXf2nDshl0tlL29MvKTrdeiolCmfi', 'app', 'password,refresh_token', '');
```

```
client_id：客户端标识
client_secret：客户端安全码，此处不能是明文，
               需要加密(System.out.println(new BCryptPasswordEncoder().encode("secret"));)
scope：客户端授权范围
authorized_grant_types：客户端授权类型(password,refresh_token表示使用密码模式, 并支持刷新token)
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

6. 得到如下的响应: 
```
{
    "access_token": "7710c8e1-3d4b-4e60-a4f9-e2fd9cb6ee32",
    "token_type": "bearer",
    "refresh_token": "36484bc6-ac33-4056-9f71-4569df45a889",
    "expires_in": 43199,
    "scope": "app"
}
```

7. 接下来就是使用access_token访问资源服务器了: (参考资源服务模块)

8. 刷新token: (因为access_token默认的有效期是12小时, 而refresh_token的有效期是30天)

    如果使用过期的access_token访问:
  ```
    {
        "error": "invalid_token",
        "error_description": "7710c8e1-3d4b-4e60-a4f9-e2fd9cb6ee32"
    }
  ```
  接下来就需要使用refresh_token去获取新的access_token:
  ```
     curl -i -X POST 
     -d 'grant_type=refresh_token&refresh_token=36484bc6-ac33-4056-9f71-4569df45a889' 
     'http://client:secret@localhost:9000/oauth/token'
  ```
  得到新的access_token:
   ```
    {
        "access_token": "032694d7-247b-4055-a319-f1bdba85038a",
        "token_type": "bearer",
        "refresh_token": "36484bc6-ac33-4056-9f71-4569df45a889",
        "expires_in": 43199,
        "scope": "app"
    }
   ```
   