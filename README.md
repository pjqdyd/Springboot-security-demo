### SpringBoot + Spring Security + Jwt整合实现基于角色权限的访问控制的案例

#### 注意:

    1.前端请求需要授权的接口时: header头部信息携带 "Authorization": "Bearer" + "登录生成的token"(即application.yml中配置的信息)