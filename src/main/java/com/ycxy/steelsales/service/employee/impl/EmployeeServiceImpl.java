package com.ycxy.steelsales.service.employee.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycxy.steelsales.mapper.employee.SteelsaleEmployeeMapper;
import com.ycxy.steelsales.pojo.employee.EmployeeQuery;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployeeExample;
import com.ycxy.steelsales.service.employee.EmployeeService;
import com.ycxy.steelsales.util.Md5Utils;
import com.ycxy.steelsales.util.SteelSaleResult;
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

    @Override
    public SteelSaleResult selectAll(EmployeeQuery employeeQuery, Integer page, Integer limit) {
        SteelSaleResult result =new SteelSaleResult();
        //设置初始页面和条数
        PageHelper.startPage((page-1)*limit,limit);
        List<SteelsaleEmployee> steelsaleEmployees = employeeMapper.fuzzySelect(employeeQuery);
        PageInfo pageInfo = new PageInfo(steelsaleEmployees);
        result.setData(pageInfo.getList());
        result.setCode(200);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public List<SteelsaleEmployee> selectEmployeeByTel(String tel) {
        SteelsaleEmployeeExample employeeExample = new SteelsaleEmployeeExample();
        SteelsaleEmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmployeeTelEqualTo(tel);
        List<SteelsaleEmployee> steelsaleEmployees = employeeMapper.selectByExample(employeeExample);
        return steelsaleEmployees;
    }

    @Override
    public SteelsaleEmployee selectEmployeeById(Integer id) {
        SteelsaleEmployee steelsaleEmployee = employeeMapper.selectByPrimaryKey(id);
        return steelsaleEmployee;
    }

    @Override
    public SteelsaleEmployee selectEmployeeByName(String s) {
        SteelsaleEmployeeExample employeeExample = new SteelsaleEmployeeExample();
        SteelsaleEmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmployeeNameEqualTo(s);
        List<SteelsaleEmployee> steelsaleEmployees = employeeMapper.selectByExample(employeeExample);
        return steelsaleEmployees.get(0);
    }

    @Override
    public List<String> selectEmployeeFunction(Integer employeeId) {

        return  employeeMapper.selectFunctionByEid(employeeId);
    }


}
