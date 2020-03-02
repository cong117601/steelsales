package com.ycxy.steelsales.controller.picture;

import com.alibaba.fastjson.JSON;

import com.ycxy.steelsales.util.PictureResult;
import com.ycxy.steelsales.util.QiNiuUtil;
import com.ycxy.steelsales.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class PictureController {

    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/employee/image")
    @ResponseBody
    public PictureResult picUpload(@RequestParam("uploadFile") MultipartFile uploadFile) {
        try {
            FileInputStream fileInputStream = (FileInputStream) uploadFile.getInputStream();
            //生成随机名称
            String saveFileName = UUID.randomUUID().toString().replace("-", "");
            QiNiuUtil.upload2Qiniu(fileInputStream, saveFileName);
            PictureResult pictureResult = new PictureResult();
            String path = QiNiuUtil.qiniu_img_url_pre + saveFileName;
            Map map = new HashMap();
            map.put("src", path);
            //把路径报错在数据中
            pictureResult.setCode(0);
            pictureResult.setData(map);
            pictureResult.setMsg("上传成功");
            redisUtil.set("src",path);
            return pictureResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
