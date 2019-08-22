package com.jt.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

    @Autowired
    MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
        .successHandler(myAuthenctiationSuccessHandler) // 自定义登录成功处理
        .failureHandler(myAuthenctiationFailureHandler) // 自定义登录失败处理 // 定义当需要用户登录时候，转到的登录页面。
        .loginPage("/login.jsp") // 设置登录页面
        .loginProcessingUrl("/user/login") // 自定义的登录接口
        .failureUrl("/failer.jsp").permitAll()
        .and()
        .logout().invalidateHttpSession(true).logoutUrl("/logout").logoutSuccessUrl("/login.jsp").permitAll()
        .and()
        .authorizeRequests()// 定义哪些URL需要被保护、哪些不需要被保护
        .antMatchers("/login.jsp","/plugins/**").permitAll() // 设置所有人都可以访问登录页面
        .anyRequest()// 任何请求,登录后可以访问
        .authenticated()
        .and()
        .csrf().disable();// 关闭csrf防护
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
}