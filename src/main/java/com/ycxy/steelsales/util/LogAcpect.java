package com.ycxy.steelsales.util;

import com.ycxy.steelsales.pojo.employee.SteelsaleEmployee;
import com.ycxy.steelsales.pojo.log.SteelsaleLogWithBLOBs;
import com.ycxy.steelsales.service.employee.EmployeeService;
import com.ycxy.steelsales.service.log.LogService;
import io.lettuce.core.ScriptOutputType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

/**
 * 日志切面
 */
@Component
@Aspect
public class LogAcpect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LogService logService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private EmployeeService employeeService;

    //定义切入点
    @Pointcut("execution(public * com.ycxy.steelsales.controller.*.*.*(..))")
    public void controllerLog() {

    }

    //配置环绕通知
    @Around("controllerLog()")
    public Object aroundLog(ProceedingJoinPoint pjp) {
        System.out.println("===============================================xxxxxxxxxxxxxxxxxxxxxx");
        Object rtValue = null;
        SteelsaleLogWithBLOBs steelsaleLog = new SteelsaleLogWithBLOBs();
        steelsaleLog.setLogUri(request.getRequestURI());//请求uri
        steelsaleLog.setLogRemoteAddr(request.getRequestURL().toString());//请求ip
//        Integer employeeId = (Integer) redisUtil.get("employeeId");
//        SteelsaleEmployee steelsaleEmployee = employeeService.selectEmployeeById(employeeId);
        steelsaleLog.setLogLoginName(request.getParameter("loginName"));
        try {
            Object[] args = pjp.getArgs();
            steelsaleLog.setLogParam(Arrays.toString(args));//请求的参数
            rtValue = pjp.proceed(args);//调用切入点方法
                if (request.getRequestURI().equals("/")){
                    steelsaleLog.setLogDesc("请求登陆");
                    return rtValue;
                }
            steelsaleLog.setLogDesc("操作成功");
            return rtValue;
        } catch (Throwable t) {
            t.getStackTrace();
//            log.info(t.getMessage());
            steelsaleLog.setLogDesc("error->:" + t.getMessage());
        } finally {
           logService.addLog(steelsaleLog);

                return rtValue;

        }

    }

}
