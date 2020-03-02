package com.ycxy.steelsales.controller.role;

import com.ycxy.steelsales.pojo.role.SteelsaleRole;
import com.ycxy.steelsales.service.role.RoleService;
import com.ycxy.steelsales.util.SteelSaleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 角色管理
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查找全部角色列表
     *
     * @return
     */
    @RequestMapping("/role/list")
    @ResponseBody
    public SteelSaleResult roleList() {
        SteelSaleResult result = new SteelSaleResult();
        List<SteelsaleRole> roles = roleService.findRoles();
        if (roles.size() > 0) {
            result.setData(roles);
            result.setCode(0);
            return result;
        }
        result.setMsg("快去添加角色");
        result.setCount(0);
        return result;
    }

    @RequestMapping("/employee/rolelist/{id}")
    @ResponseBody
    public SteelSaleResult employeeRoles(@PathVariable Integer id) {
        SteelSaleResult result = new SteelSaleResult();
        //一个用户对应多个角色
        List<Integer> roles = roleService.findRolesByEmployeeId(id);
        result.setCode(0);
        result.setData(roles);
        return result;
    }
}
