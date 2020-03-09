package com.ycxy.steelsales.security;

import com.ycxy.steelsales.service.login.impl.EmployeeLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 自定义安全认证
 * 自定义认证逻辑
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private EmployeeLoginServiceImpl userDetailsService;
    @Autowired
    private PasswordEncoder myPasswordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()//加上csrf保护措施
                .disable()
                .authorizeRequests()//需要授权的请求
                .antMatchers( "/","/ran/random","/employee/sendEmail","/password","/register","/employee/register","/employee/sendPhone").permitAll()//允许匿名访问的url
                .anyRequest().hasAnyAuthority("ROLE_BOSS")//老板所有路径都可以访问
//                .antMatchers("/admin/user/getuserList",
//                        "/admin/user/updateUserPwd",
//                        "/admin/user/updateuserstate").hasAnyAuthority("ROLE_MANAGER")//经理
                .antMatchers("/employee/list","/employee-list2"
                        ).hasAnyAuthority("ROLE_EMPLOYEE")//employee 普通员工
                .anyRequest().authenticated()//指定其他路径必须登陆后才可访问
                .and()/* 完成上一个配置，进行下一步配置 */
//                .sessionManagement() //session超时管理
//                .invalidSessionUrl("/login") //session超时跳向的url
                //.and()
                .formLogin()//当用户需要的登陆的时候 跳转的登陆页面
                .loginPage("/")
                .loginProcessingUrl("/login")
                .successForwardUrl("/login1")//验证成功后跳转的页面
                .failureForwardUrl("/toError")//验证失败后默认跳转页面
                //需要和该框架对应的name属性 若不对应则修改
                .usernameParameter("loginName")//修改表单中用户名name属性
                .passwordParameter("loginPwd")//修改表单中密码name属性
                .and()
                .logout()
                .logoutUrl("/logout")//自定义登出
                .logoutSuccessUrl("/");//退出登录后跳转的url

        http.headers().frameOptions().disable();

    }


    /**
     * 对密码进行加密系统
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(myPasswordEncoder);
    }

    /**
     * 拦截静态资源
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(   "/static/**");
    }
}
