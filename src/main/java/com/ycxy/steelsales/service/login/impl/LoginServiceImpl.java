package com.ycxy.steelsales.service.login.impl;

import com.ycxy.steelsales.mapper.employee.SteelsaleEmployeeMapper;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployeeExample;
import com.ycxy.steelsales.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SteelsaleEmployeeMapper employeeMapper;
    @Override
    public SteelsaleEmployee findEmployeeByUserName(String username) {
        SteelsaleEmployeeExample steelsaleEmployeeExample = new SteelsaleEmployeeExample();
        SteelsaleEmployeeExample.Criteria criteria = steelsaleEmployeeExample.createCriteria();
        criteria.andLoginNameEqualTo(username);
        List<SteelsaleEmployee> steelsaleEmployees = employeeMapper.selectByExample(steelsaleEmployeeExample);
        return steelsaleEmployees.get(0);
    }
}
