package com.ycxy.steelsales.util;

import java.io.Serializable;

/**
 * 封装返回结果
 */
public class SteelSaleResult implements Serializable {
    private Integer code;
    private String msg;

    public SteelSaleResult() {
    }

    public SteelSaleResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
