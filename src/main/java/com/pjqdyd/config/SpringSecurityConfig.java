package com.pjqdyd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *    
 *
 * @Description:  [Spring Security的配置类]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 *  
 */


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 安全管理器方法, 提供认证信息
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("pjqdyd")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .authorities("PRODUCT_ADD");
    }

    /**
     * http安全配置方法,拦截,配置接口所需用户权限
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/product/list").hasAuthority("PRODUCT_LIST")
                .antMatchers("/product/add").hasAuthority("PRODUCT_ADD")
                .antMatchers("/product/update").hasAuthority("PRODUCT_UPDATE")
                .antMatchers("/product/delete").hasAuthority("PRODUCT_DELETE")
                .antMatchers("/**")
                .fullyAuthenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable();
    }

    /**
     * 配置忽略拦截一些静态页面资源,如swagger的页面
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs",
                    "/swagger-ui.html",
                    "**/swagger-ui.html",
                    "/**/*.css",
                    "/**/*.js",
                    "/**/*.png",
                    "/swagger-resources/**",
                    "/v2/**",
                    "/**/*.ttf"
        );
    }
}
