package com.pjqdyd.config;

import com.pjqdyd.filter.CustomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

/**
 *    
 *
 * @Description:  [资源服务配置]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 *  
 */

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public CustomFilter customFilter(){ //添加自定义的过滤器
        return new CustomFilter();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .and()
                //STATELESS不创建session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAuthority("PERM_ADMIN_SELECT")
                .antMatchers("/admin/delete").hasAuthority("PERM_ADMIN_DELETE")
                .antMatchers("/user/**").hasAuthority("PERM_USER_SELECT")
                .antMatchers("/user/delete").hasAuthority("PERM_USER_DELETE")//对应认证服务器中用户的权限
                .and()
                .addFilterBefore(customFilter(), WebAsyncManagerIntegrationFilter.class); //加入过滤器链,在进入后者之前就进行过滤
    }
}
