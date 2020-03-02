package com.ycxy.steelsales.util;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

/**
 * 阿里云短信发送
 */
@Component
public class SendSms {
    private static final String accessKeyId = "LTAI4FrmRtSmGrAYwQgMVu3k"; //阿里云accessKeyId
    private static final String accessKeySecret = "hnMTYXR3IC7B452hIuQjSZOnF9btlW"; //阿里云accessKeySecret
    private static final String signName = "从哥美食"; //阿里云的签名名称
    private static final String templateCode = "SMS_181854669"; //阿里云的模板Code

    public static SmsResult SendCode(String telphone, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", telphone);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
//        request.putQueryParameter("TemplateParam", "{\"code\":" + code + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            String data = response.getData();
            SmsResult result = JSON.parseObject(data, SmsResult.class);
            return result;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void fasong(String telphone, String code) {
        System.out.println(telphone + code);
        SendSms.SendCode(telphone, code);
    }

}