package com.ycxy.steelsales.service.log;

import com.ycxy.steelsales.pojo.log.SteelsaleLog;
import com.ycxy.steelsales.pojo.log.SteelsaleLogWithBLOBs;
import com.ycxy.steelsales.util.ResultMessage;
import com.ycxy.steelsales.util.SteelSaleResult;

import java.util.List;

/**
 * 日志
 */
public interface LogService {


    Boolean addLog(SteelsaleLogWithBLOBs steelsaleLog);

    /**
     * es 日志查询
     * @param keyword
     * @return
     */
    ResultMessage showLog(String keyword);
}
