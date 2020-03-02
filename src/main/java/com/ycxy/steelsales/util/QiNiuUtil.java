package com.ycxy.steelsales.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

/**
 * 七牛云工具类
 */
@Component
public class QiNiuUtil {
    public static String qiniu_img_url_pre;

    public static String ACCESS_KEY;

    public static String SECRET_KEY;

    public static String bucketname;

    @Value("${qiniu.img_url_pre}")
    public void setQiniu_img_url_pre(String qiniu_img_url_pre) {
        QiNiuUtil.qiniu_img_url_pre = qiniu_img_url_pre;
    }

    @Value("${qiniu.ACCESS_KEY}")
    public void setAccessKey(String accessKey) {
        ACCESS_KEY = accessKey;
    }

    @Value("${qiniu.SECRET_KEY}")
    public void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }

    @Value("${qiniu.bucketname}")
    public void setBucketname(String bucketname) {
        QiNiuUtil.bucketname = bucketname;
    }

    /**
     * 上传文件
     * //  * @param bytes 文件内容，字节数组
     *
     * @param uploadFileName 保存到服务端的文件名
     */
    public static void upload2Qiniu(FileInputStream file, String uploadFileName) {
        //构造一个带指定Zone对象的配置类,Zone.zone0()代表华东地区
        //zone2() 华南
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = uploadFileName;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(bucketname);
        try {
            Response response = uploadManager.put(file, key, upToken, null, null);
            //解析上传成功的结果
            System.out.println(response.bodyString());
            // 访问路径
            System.out.println(qiniu_img_url_pre + uploadFileName);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
                ex.printStackTrace();
            }
        }
    }
}