### SpringBoot + Spring Security + Jwt整合实现基于角色的访问控制的案例

   
#### 如何测试:
    1. 修改application.yml配置数据库连接, 创建Mysql数据库db_spring_security.
    2. 启动SpringBoot项目生成User, Role相关表.
    3. 运行测试类MainTest中的方法, 添加一些用户角色数据.
    4. 访问localhost:8080/swagger-ui.html登录用户, 获取token.
    5. 使用postman工具测试接口(header头部信息携带 "Authorization": "Bearer" + "登录生成的token").
    

(注意: 这里为了简化就没有设置3张表, 只关联了用户与角色2张表的信息)

如果要使用本jwt又要关联3张表, 请参考oauth2的loadUserByUsername方法
