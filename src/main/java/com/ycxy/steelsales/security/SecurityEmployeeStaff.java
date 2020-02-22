package com.ycxy.steelsales.security;

import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 自定义的用户登陆
 */
public class SecurityEmployeeStaff extends SteelsaleEmployee implements UserDetails {
    private String loginName;
    private String loginPwd;
    List<GrantedAuthority> authorities;

    public SecurityEmployeeStaff(String loginName, String loginPwd , List<GrantedAuthority> authorities){
        this.loginPwd=loginPwd;
        this.loginName=loginName;
        this.authorities=authorities;
    }


    @Override//获取数据库中存储的用户role
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override//获取数据库存储的密码
    public String getPassword() {

        return loginPwd;
    }

    @Override//获取数据库存储的账号
    public String getUsername() {
        return loginName;
    }

    @Override//账号过期验证
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override//账号是否被锁定
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override//证书（密码）过期验证
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override//账号有效验证
    public boolean isEnabled() {
        return true;
    }
}
