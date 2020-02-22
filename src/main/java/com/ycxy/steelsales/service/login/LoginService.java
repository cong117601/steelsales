package com.ycxy.steelsales.service.login;

import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;

/**
 * 员工登陆
 */
public interface LoginService {
    //根据登陆名查找员工
    public SteelsaleEmployee findEmployeeByUserName(String username);
}
