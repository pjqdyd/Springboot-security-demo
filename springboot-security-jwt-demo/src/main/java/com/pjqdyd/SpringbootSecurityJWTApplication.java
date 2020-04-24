package com.pjqdyd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**   
 * @Description:  [SpringbootSecurity JWT 启动类]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.pjqdyd.mapper")
public class SpringbootSecurityJWTApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityJWTApplication.class);
    }

}
