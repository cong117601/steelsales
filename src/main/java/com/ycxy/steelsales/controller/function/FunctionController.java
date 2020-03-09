package com.ycxy.steelsales.controller.function;

import com.ycxy.steelsales.pojo.function.SteelsaleFunction;
import com.ycxy.steelsales.pojo.roleAndFunction.SteelsaleRoleFunction;
import com.ycxy.steelsales.service.function.FunctionService;
import com.ycxy.steelsales.service.roleAndFunction.RoleAndFunctionSerivice;
import com.ycxy.steelsales.util.SteelSaleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限控制器
 */
@Controller
public class FunctionController {
    @Autowired
    private FunctionService functionService;
    @Autowired
    private RoleAndFunctionSerivice rfSerivice;

    @RequestMapping("/function/listAllFunction")
    @ResponseBody
    public Object findAllFunction() {
        Map map = new HashMap<>();
        List<SteelsaleFunction> menulists = functionService.findAllFunction();
        map.put("menulists", menulists);
        return map;
    }

    /**
     * 根据角色id 查找权限
     *
     * @param id
     * @return
     */
    @RequestMapping("/function/findfunction/{id}")
    @ResponseBody
    public SteelSaleResult findOneRoleFunction(@PathVariable("id") Integer id) {
        SteelSaleResult result = new SteelSaleResult();
        System.out.println(id);
        List<SteelsaleRoleFunction> functions = rfSerivice.findFunctionByRoleId(id);
        result.setData(functions);
        result.setCode(0);
        return result;
    }

    /**
     * 添加权限到权限表
     *
     * @param function
     * @return
     */
    @RequestMapping("/function/add")
    @ResponseBody
    public SteelSaleResult addFunction(SteelsaleFunction function) {
        SteelSaleResult result = new SteelSaleResult();
        function.setCreateTime(new Date());
        functionService.addFunction(function);
        result.setCode(0);
        return result;
    }

    /**
     * 修改权限
     * @param function
     * @return
     */
    @RequestMapping("/function/update")
    @ResponseBody
    public SteelSaleResult updateFunction(SteelsaleFunction function){
        SteelSaleResult result = new SteelSaleResult();
        functionService.updateFunction(function);
        result.setCode(0);
        return result;
    }
    @RequestMapping("/function/delete")
    @ResponseBody
    public SteelSaleResult deleteFunction(Integer functionId){
        SteelSaleResult result = new SteelSaleResult();
        functionService.removeFunctionByFunctionId(functionId);
        rfSerivice.removeFunctionByFunctionId(functionId);
        result.setCode(0);
        return result;
    }
}
