package com.ycxy.steelsales.util;

import java.io.Serializable;

/**
 * 封装返回结果
 */
public class SteelSaleResult implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    private Integer count;

    public SteelSaleResult() {
    }

    public SteelSaleResult(Integer code, String msg, Object data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
