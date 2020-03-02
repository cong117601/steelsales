package com.ycxy.steelsales.controller.employee;

import com.ycxy.steelsales.pojo.employee.EmployeeQuery;
import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.pojo.employeeAndrole.SteelsaleEmployeeRole;
import com.ycxy.steelsales.pojo.employeepicture.SteelsaleEmployeePicture;
import com.ycxy.steelsales.service.employee.EmployeeService;
import com.ycxy.steelsales.service.employeeAndrole.EAndRoleService;
import com.ycxy.steelsales.service.employeepicture.EPictureService;
import com.ycxy.steelsales.service.login.LoginService;
import com.ycxy.steelsales.service.role.RoleService;
import com.ycxy.steelsales.util.Md5Utils;
import com.ycxy.steelsales.util.RedisUtil;
import com.ycxy.steelsales.util.SteelSaleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 员工controller
 */
@Controller
public class EmployeeController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EAndRoleService eAndRoleService;
    @Autowired
    private EPictureService ePictureService;

    /**
     * 跳转登陆页面
     */
    @RequestMapping("/")
    public String toLoginPage() {
        return "login";
    }

    /**
     * 员工登陆
     */
    @RequestMapping("/login1")
    public ModelAndView employeeLogin(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        SteelsaleEmployee employee = loginService.findEmployeeByUserName(name);
        //获取验证码
        String code = (String) redisUtil.get("code");
        //获取请求参数 验证码
        String captcha = request.getParameter("captcha");
        if (code == null || !code.equals(captcha)) {
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        modelAndView.addObject("role", name);
        redisUtil.set("employeeId", employee.getEmployeeId());
        return modelAndView;
    }

    /**
     * 员工列表
     *
     * @param employeeQuery
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/employee/list")
    @ResponseBody
    public SteelSaleResult employeeAll(EmployeeQuery employeeQuery, Integer page, Integer limit) {
        SteelSaleResult result = employeeService.selectAll(employeeQuery, page, limit);
        return result;
    }

    /**
     * 修改密码
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/employee/passwordEdit/{id}")
    @ResponseBody
    public SteelSaleResult employeeEditPwd(HttpServletRequest request, @PathVariable("id") Integer id) {
        SteelSaleResult result = new SteelSaleResult();
        String oldPassword = request.getParameter("oldPassword");
        String employeePwd = request.getParameter("employeePwd");
        String repassword = request.getParameter("repassword");
        SteelsaleEmployee steelsaleEmployee = employeeService.selectEmployeeById(id);
        if (employeePwd.equals(repassword) && !steelsaleEmployee.equals("null")) {
            steelsaleEmployee.setLoginPwd(Md5Utils.stringToMD5(repassword));
            employeeService.updateEmployee(steelsaleEmployee);
            result.setCode(0);
            return result;
        }
        result.setMsg("请核对后再更改");
        return result;
    }

    /**
     * 修改员工状态
     *
     * @param request
     * @return
     */
    @RequestMapping("/employee/editstatus")
    @ResponseBody
    public SteelSaleResult employeeStatus(HttpServletRequest request) {
        SteelSaleResult result = new SteelSaleResult();
        String employeeId = request.getParameter("employeeId");
        String status = request.getParameter("status");
        //等于false status==1
        if (status.equals("false")) {
            SteelsaleEmployee steelsaleEmployee = employeeService.selectEmployeeById(Integer.valueOf(employeeId));
            steelsaleEmployee.setStatus((byte) 1);
            employeeService.updateEmployee(steelsaleEmployee);
            result.setCode(0);
            return result;
        }
        SteelsaleEmployee steelsaleEmployee = employeeService.selectEmployeeById(Integer.valueOf(employeeId));
        steelsaleEmployee.setStatus((byte) 0);
        employeeService.updateEmployee(steelsaleEmployee);
        result.setCode(0);
        return result;

    }

    /**
     * 删除功能
     *
     * @param employeeId
     * @return
     */
    @RequestMapping("/employee/delete/{id}")
    @ResponseBody
    public SteelSaleResult deleteEmployee(@PathVariable("id") Integer employeeId) {
        SteelSaleResult result = new SteelSaleResult();
        SteelsaleEmployee steelsaleEmployee = employeeService.selectEmployeeById(Integer.valueOf(employeeId));
        steelsaleEmployee.setStatus((byte) 1);
        employeeService.updateEmployee(steelsaleEmployee);
        result.setCode(200);
        return result;
    }

    /**
     * @param ids
     * @return
     */
    @RequestMapping("/employee/deleteBatch")
    @ResponseBody
    public SteelSaleResult deleteEmployees(@RequestParam List<Integer> ids) {
        SteelSaleResult result = new SteelSaleResult();
        if (ids.size() > 0) {
            for (Integer employeeId : ids) {
                SteelsaleEmployee steelsaleEmployee = employeeService.selectEmployeeById(Integer.valueOf(employeeId));
                steelsaleEmployee.setStatus((byte) 1);
                employeeService.updateEmployee(steelsaleEmployee);
            }
            result.setCode(200);
            return result;
        }
        result.setMsg("请选择要删除的员工");
        return result;
    }

    /**
     * 根据id 找出员工
     *
     * @param id
     * @return
     */
    @RequestMapping("/employee/findemployee/{id}")
    @ResponseBody
    public SteelSaleResult findEmployye(@PathVariable("id") Integer id) {
        SteelSaleResult result = new SteelSaleResult();
        SteelsaleEmployee steelsaleEmployee = employeeService.selectEmployeeById(id);
        result.setData(steelsaleEmployee);
        result.setCode(0);
        return result;
    }


    /**
     * 添加员工
     *
     * @param employee
     * @param request
     * @return
     */
    @RequestMapping("/employee/save")
    @ResponseBody
    public SteelSaleResult saveEmployee(SteelsaleEmployee employee, HttpServletRequest request) {
        SteelSaleResult result = new SteelSaleResult();
        //设置员工得初始密码
        employee.setLoginPwd(Md5Utils.stringToMD5("111111"));
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        employee.setEmployeeSalary(3000.0);
        employeeService.addEmployee(employee);
        //插入完成之后 需要获取该员工的id
        List<SteelsaleEmployee> steelsaleEmployees = employeeService.selectEmployeeByEmail(employee.getEmployeeEmail());
        Integer employeeId = steelsaleEmployees.get(0).getEmployeeId();
        //设置员工得角色
        String roleMsg = request.getParameter("roleMsg");
        String[] split = roleMsg.split(",");
        SteelsaleEmployeeRole eAndROle = new SteelsaleEmployeeRole();
        eAndROle.setEmployeeId(employeeId);
        for (String id : split) {
            eAndROle.setRoleId(Integer.valueOf(id));
            //循环插入到 员工与角色关联表中
            eAndRoleService.addEmployeeAndRole(eAndROle);
        }
        //设置员工默认图片
        String pictureSrc = request.getParameter("employeePicture");
        SteelsaleEmployeePicture ePicture = new SteelsaleEmployeePicture();
        ePicture.setEmployeeId(employeeId);
        ePicture.setPictureSrc("http://q3xosoc97.bkt.clouddn.com/cd93ad2a0382401ab32cfc6db7e6d0ca");
        ePictureService.insertEpicture(ePicture);
        result.setCode(0);
        return result;
    }

    /**
     * 根据员工id 修改信息
     *
     * @param employee
     * @param request
     * @return
     */
    @RequestMapping("/employee/edit")
    @ResponseBody
    public SteelSaleResult editEmployee(SteelsaleEmployee employee, HttpServletRequest request) {
        SteelSaleResult result = new SteelSaleResult();
        //修改用户的基本信息
        employee.setUpdateTime(new Date());
        employeeService.updateEmployee(employee);
        //修改图片
        String employeeImage = request.getParameter("employeeImage");
        ePictureService.editEpictureByEmId(employee.getEmployeeId(), employeeImage);
        //修改角色 由于角色有可能减少有可能增加，不如把全部关于这个用户的角色删除，在重新添加
        String roleMsg = request.getParameter("roleMsg");
        //获取修改后的角色id
        String[] split = roleMsg.split(",");
        //删除该员工的角色关系
        eAndRoleService.removeRoles(employee.getEmployeeId());
        //添加该员工的角色关系
        SteelsaleEmployeeRole employeeRole = new SteelsaleEmployeeRole();
        employeeRole.setEmployeeId(employee.getEmployeeId());
        for (String rid : split) {
            employeeRole.setRoleId(Integer.parseInt(rid));
            System.out.println(rid);
            //eAndRoleService.addRolesByEmployeeId(employee.getEmployeeId(),Integer.parseInt(rid));
            eAndRoleService.addEmployeeAndRole(employeeRole);
        }
        result.setCode(0);
        return result;
    }
}
