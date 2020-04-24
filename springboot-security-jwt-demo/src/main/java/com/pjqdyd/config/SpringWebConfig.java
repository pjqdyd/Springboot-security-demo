package com.pjqdyd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**   
 * @Description:  [WebConfig]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@Configuration
public class SpringWebConfig implements WebMvcConfigurer {

    /**
     * 跨域访问设置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
