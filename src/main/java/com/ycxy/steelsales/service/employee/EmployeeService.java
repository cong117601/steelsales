package com.ycxy.steelsales.service.employee;

import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;

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
}
