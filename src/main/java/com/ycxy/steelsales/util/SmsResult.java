package com.ycxy.steelsales.util;

/**
 * 短信发送接口
 */
public class SmsResult {
    private String Message;
    private String RequestId;
    private String BizId;
    private String Code;

    public SmsResult() {
    }

    public SmsResult(String message, String requestId, String bizId, String code) {
        Message = message;
        RequestId = requestId;
        BizId = bizId;
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public String getBizId() {
        return BizId;
    }

    public void setBizId(String bizId) {
        BizId = bizId;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
