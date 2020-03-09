package com.ycxy.steelsales.pojo.log;

public class SteelsaleLogWithBLOBs extends SteelsaleLog {
    private String logParam;

    private String logDesc;

    public String getLogParam() {
        return logParam;
    }

    public void setLogParam(String logParam) {
        this.logParam = logParam == null ? null : logParam.trim();
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc == null ? null : logDesc.trim();
    }
}