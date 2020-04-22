### SpringBoot + Spring Security 整合实现基于 RBAC角色权限的访问控制的案例

#### 项目环境:

   >1. SpringBoot 2.1.4.RELEASE / SpringBoot 2.1.8.RELEASE
   >2. Spring Data Jpa / Mybatis
   >3. Mysql 8.0.15
   >4. Maven 3.5.4
   >5. Lombok 插件
   >6. 开发工具 IDEA

#### 项目模块:
    ```
      ├─springboot-security-jwt-demo                Springboot + Security + Jwt整合基于RBAC的模块
      ├─springboot-security-oauth2-server-demo      Springboot + Security OAuth2整合的基于RBAC认证服务模块
      ├─springboot-security-oauth2-resources-demo   Springboot + Security OAuth2整合的基于RBAC资源服务模块
      ├─.gitignore                                  .gitignore文件
      ├─README.md                                   README.md文件
      └─pom.xml                                     父模块pom文件
     ```
     
  (注意: 运行单个模块前请仔细查看该模块下的README.md)
   
