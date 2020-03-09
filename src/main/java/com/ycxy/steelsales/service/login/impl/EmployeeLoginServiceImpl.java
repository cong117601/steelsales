package com.ycxy.steelsales.service.login.impl;

import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.service.employee.EmployeeService;
import com.ycxy.steelsales.service.login.LoginService;
import com.ycxy.steelsales.service.role.RoleService;
import com.ycxy.steelsales.security.SecurityEmployeeStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 使用springsecurity 需要实现userDetailsService
 * 并且找出该用户所属角色
 *
 */
@Service
public class EmployeeLoginServiceImpl implements UserDetailsService {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmployeeService employeeService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据登陆名 查找用户
        SteelsaleEmployee employee = loginService.findEmployeeByUserName(s);
        if(employee==null){
            throw new UsernameNotFoundException("账号不存在");
        }
        //根据用户名找出id
//       SteelsaleEmployee employ= employeeService.selectEmployeeByName(s);
//        //查出该用户所拥有的权限
//        List<String> employeeFunction=employeeService.selectEmployeeFunction(employ.getEmployeeId());
        List<String> steelsaleRoles = roleService.selectRoleByLoginName(s);
        System.out.println(steelsaleRoles.size());
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String i : steelsaleRoles) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(i);
                authorities.add(grantedAuthority);
        }
        SecurityEmployeeStaff securityUserStaff = new SecurityEmployeeStaff(employee.getLoginName(), employee.getLoginPwd(), authorities);
        return securityUserStaff;
      // return new org.springframework.security.core.userdetails.User(employee.getLoginName(), employee.getLoginPwd(), authorities);
    }
}
