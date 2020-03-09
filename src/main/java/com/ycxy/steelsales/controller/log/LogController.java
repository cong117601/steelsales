package com.ycxy.steelsales.controller.log;

import com.ycxy.steelsales.pojo.log.SteelsaleLog;
import com.ycxy.steelsales.service.log.LogService;
import com.ycxy.steelsales.util.ResultMessage;
import com.ycxy.steelsales.util.SteelSaleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 日志接口
 */
@Controller
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/log/show")
    @ResponseBody
    public ResultMessage showLog(String keyword) {

        ResultMessage logs=logService.showLog(keyword);

        return logs;

    }

}
