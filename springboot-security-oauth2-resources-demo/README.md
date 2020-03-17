#### Spring Security 整合OAuth2的资源服务模块

1. 先运行认证服务模块, 根据README获取到access_token

2. 再启动本资源服务模块, 使用access_token访问资源:

如获取的access_token=7710c8e1-3d4b-4e60-a4f9-e2fd9cb6ee32:

就使用如下方式请求接口资源:
```
curl -X GET
 -H "Authorization: Bearer 7710c8e1-3d4b-4e60-a4f9-e2fd9cb6ee32"
 -H "Content-Type: application/json" 
'http://localhost:8000/admin' 
```