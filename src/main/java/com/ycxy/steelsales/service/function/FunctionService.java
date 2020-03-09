package com.ycxy.steelsales.service.function;

import com.ycxy.steelsales.pojo.function.SteelsaleFunction;
import com.ycxy.steelsales.pojo.roleAndFunction.SteelsaleRoleFunction;

import java.util.List;

/**
 * 权限接口
 */
public interface FunctionService {
    /**
     * 查找所有权限
     * @return
     */
    List<SteelsaleFunction> findAllFunction();

    /**
     * 添加权限
     * @param function
     */
    void addFunction(SteelsaleFunction function);

    /**
     * 修改权限
     * @param function
     */
    void updateFunction(SteelsaleFunction function);

    /**
     * 删除权限
     * @param functionId
     */
    void removeFunctionByFunctionId(Integer functionId);
}
