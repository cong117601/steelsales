package com.ycxy.steelsales.service.employee.impl;

import com.ycxy.steelsales.mapper.employee.SteelsaleEmployeeMapper;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployeeExample;
import com.ycxy.steelsales.service.employee.EmployeeService;
import com.ycxy.steelsales.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private SteelsaleEmployeeMapper employeeMapper;

    @Override
    public List<SteelsaleEmployee> selectEmployeeByEmail(String email) {
        SteelsaleEmployeeExample employeeExample = new SteelsaleEmployeeExample();
        SteelsaleEmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmployeeEmailEqualTo(email);
        List<SteelsaleEmployee> steelsaleEmployees = employeeMapper.selectByExample(employeeExample);
        return steelsaleEmployees;
    }

    @Override
    public void updateEmployee(SteelsaleEmployee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    public void addEmployee(SteelsaleEmployee employee) {
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        employee.setLoginPwd(Md5Utils.stringToMD5(employee.getLoginPwd()));
        employee.setEmployeeSex((byte)0);
        employee.setStatus((byte)0);
        employee.setEmployeeSalary(3000.00);
        employeeMapper.insertSelective(employee);
    }
}
