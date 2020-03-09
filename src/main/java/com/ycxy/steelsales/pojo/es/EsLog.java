package com.ycxy.steelsales.pojo.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 存入es库的数据类
 */
@Document(indexName ="eslog",type = "eslogInfo")
public class EsLog implements Serializable {

    @Id
    private Long id;

    //    @Field(type= FieldType.Text,analyzer="ik_max_work",searchAnalyzer="ik_max_word")
    private String logTime;

    private String logLoginName;

    private String logRemoteAddr;

    private String logUri;

    private String logParam;

    private String logDesc;

    public EsLog() {
    }

    public EsLog(Long id, String logTime, String logLoginName, String logRemoteAddr, String logUri, String logParam, String logDesc) {
        this.id = id;
        this.logTime = logTime;
        this.logLoginName = logLoginName;
        this.logRemoteAddr = logRemoteAddr;
        this.logUri = logUri;
        this.logParam = logParam;
        this.logDesc = logDesc;
    }

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
        this.logLoginName = logLoginName;
    }

    public String getLogRemoteAddr() {
        return logRemoteAddr;
    }

    public void setLogRemoteAddr(String logRemoteAddr) {
        this.logRemoteAddr = logRemoteAddr;
    }

    public String getLogUri() {
        return logUri;
    }

    public void setLogUri(String logUri) {
        this.logUri = logUri;
    }

    public String getLogParam() {
        return logParam;
    }

    public void setLogParam(String logParam) {
        this.logParam = logParam;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    @Override
    public String toString() {
        return "EsLog{" +
                "id=" + id +
                ", logTime='" + logTime + '\'' +
                ", logLoginName='" + logLoginName + '\'' +
                ", logRemoteAddr='" + logRemoteAddr + '\'' +
                ", logUri='" + logUri + '\'' +
                ", logParam='" + logParam + '\'' +
                ", logDesc='" + logDesc + '\'' +
                '}';
    }
}
