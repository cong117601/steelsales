package com.ycxy.steelsales.service.employee;

import com.ycxy.steelsales.pojo.employee.EmployeeQuery;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.util.SteelSaleResult;

import java.util.List;

/**
 * 员工
 */
public interface EmployeeService {
    /**
     * 通过员工邮箱查找改员工信息
     * @param email
     * @return
     */

    List<SteelsaleEmployee> selectEmployeeByEmail(String email);

    /**
     * 修改员工密码
     * @param employee
     */
    void updateEmployee(SteelsaleEmployee employee);

    /**
     * 添加员工
     * @param employee
     */
    void addEmployee(SteelsaleEmployee employee);

    /**
     * 查询所有员工 模糊查询 分页
     * @param employeeQuery
     * @param page
     * @param limit
     * @return
     */
    SteelSaleResult selectAll(EmployeeQuery employeeQuery, Integer page, Integer limit);

    /**
     * 根据员工电话查找员工
     * @param tel
     * @return
     */
    List<SteelsaleEmployee> selectEmployeeByTel(String tel);

    /**
     * 根据id 查找员工
     * @param id
     * @return
     */
    SteelsaleEmployee selectEmployeeById(Integer id);


    SteelsaleEmployee selectEmployeeByName(String s);

    List<String> selectEmployeeFunction(Integer employeeId);
}
