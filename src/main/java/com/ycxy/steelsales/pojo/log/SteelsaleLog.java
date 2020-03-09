package com.ycxy.steelsales.pojo.log;

import java.io.Serializable;
import java.lang.String;

public class SteelsaleLog implements Serializable {
    private Long id;

    private String logTime;

    private String logLoginName;

    private String logRemoteAddr;

    private String logUri;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogLoginName() {
        return logLoginName;
    }

    public void setLogLoginName(String logLoginName) {
        this.logLoginName = logLoginName == null ? null : logLoginName.trim();
    }

    public String getLogRemoteAddr() {
        return logRemoteAddr;
    }

    public void setLogRemoteAddr(String logRemoteAddr) {
        this.logRemoteAddr = logRemoteAddr == null ? null : logRemoteAddr.trim();
    }

    public String getLogUri() {
        return logUri;
    }

    public void setLogUri(String logUri) {
        this.logUri = logUri == null ? null : logUri.trim();
    }
}