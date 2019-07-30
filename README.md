### SpringBoot + Spring Security + Jwt整合实现基于角色权限的访问控制的案例

#### 项目环境:

   >1. SpringBoot 2.1.4.RELEASE
   >2. Spring Data Jpa
   >3. Mysql 8.0.15
   >4. Maven 3.5.4
   >5. Lombok 插件
   >6. 开发工具 IDEA
   
#### 如何测试:
    1. 修改application.yml配置数据库连接, 创建Mysql数据库db_spring_security.
    2. 启动SpringBoot项目生成User, Role相关表.
    3. 运行测试类MainTest中的方法, 添加一些用户角色数据.
    4. 访问localhost:8080/swagger-ui.html登录用户, 获取token.
    5. 使用postman工具测试接口(header头部信息携带 "Authorization": "Bearer" + "登录生成的token").
