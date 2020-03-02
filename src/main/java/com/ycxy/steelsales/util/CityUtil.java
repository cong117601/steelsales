package com.ycxy.steelsales.util;

import java.io.Serializable;

/**
 * 封装城市 存在ctiy字段中
 */
public class CityUtil implements Serializable {

    private String area;

    private String city;


    private String province;

    public CityUtil() {
    }

    public CityUtil(String province, String city, String area) {
        this.province = province;
        this.city = city;
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
