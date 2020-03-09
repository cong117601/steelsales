package com.ycxy.steelsales.controller.role;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.ycxy.steelsales.pojo.role.SteelsaleRole;
import com.ycxy.steelsales.pojo.roleAndFunction.SteelsaleRoleFunction;
import com.ycxy.steelsales.service.role.RoleService;
import com.ycxy.steelsales.service.roleAndFunction.RoleAndFunctionSerivice;
import com.ycxy.steelsales.util.SteelSaleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色管理
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleAndFunctionSerivice roleAndFunctionSerivice;

    /**
     * 查找全部角色列表 在员工添加时
     *
     * @return
     */
    @RequestMapping("/employeerole/list")
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

    /**
     * 根据id 查找该用户的角色
     *
     * @param id
     * @return
     */
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

    /**
     * 模糊查询 角色列表
     *
     * @param roleName
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/role/list")
    @ResponseBody
    public SteelSaleResult rolesList(String roleName, Integer page, Integer limit) {
        SteelSaleResult result = new SteelSaleResult();
        PageHelper.startPage(page, limit);
        List<SteelsaleRole> roles = roleService.findRoles(roleName, page, limit);
        PageInfo pageInfo = new PageInfo(roles);
        result.setData(pageInfo.getList());
        result.setCode(0);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    /**
     * 添加角色
     *
     * @param steelsaleRole
     * @return
     */
    @RequestMapping("/role/add")
    @ResponseBody
    public SteelSaleResult addRole(SteelsaleRole steelsaleRole, String permissionIds) {
        SteelSaleResult result = new SteelSaleResult();
        steelsaleRole.setCreateTime(new Date());
        roleService.addRole(steelsaleRole);
        //根据角色名查找该角色的id
        SteelsaleRole role = roleService.findRoleByRoleName(steelsaleRole.getRoleName());
        //添加该角色的权限信息
        SteelsaleRoleFunction roleFunction = new SteelsaleRoleFunction();
        roleFunction.setRoleId(role.getRoleId());

        System.out.println(permissionIds);
        String[] split = permissionIds.split(",");
        // permissionIds.remove("0");
        for (String id : split) {
            roleFunction.setFunctionId(Integer.parseInt(id));
            roleAndFunctionSerivice.insertRoleOfFunction(roleFunction);
        }
        result.setCode(0);
        return result;
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @RequestMapping("/role/delete/{id}")
    @ResponseBody
    public SteelSaleResult deleteRole(@PathVariable Integer id) {
        SteelSaleResult result = new SteelSaleResult();
        roleService.removeRole(id);
        //删除该角色所有的权限
        roleAndFunctionSerivice.removeFunctionByRoleId(id);
        result.setCode(0);
        return result;
    }

    /**
     * 根据id 查找角色
     *
     * @param id
     * @return
     */
    @RequestMapping("/role/finderole/{id}")
    @ResponseBody
    public SteelSaleResult findOneRole(@PathVariable Integer id) {
        SteelSaleResult result = new SteelSaleResult();
        SteelsaleRole role = roleService.findRoleById(id);
        result.setData(role);
        result.setCode(0);
        return result;
    }


    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/role/edit")
    @ResponseBody
    public SteelSaleResult editRole(SteelsaleRole role, String permissionIds) {
        SteelSaleResult result = new SteelSaleResult();
        roleService.editRole(role);
        //删除该角色对应的权限
        roleAndFunctionSerivice.removeFunctionByRoleId(role.getRoleId());
        //修改角色的权限
        String[] split = permissionIds.split(",");
        List<Integer> integers = new ArrayList<>();
        for (String funtionId : split) {
            integers.add(Integer.parseInt(funtionId));
        }
        roleAndFunctionSerivice.updateFunctionByRoleId(role.getRoleId(),integers);
        result.setCode(0);
        return result;
    }


}
