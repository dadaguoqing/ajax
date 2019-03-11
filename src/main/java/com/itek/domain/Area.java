package com.itek.domain;

/**
 * Class: Area
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/816:16
 * Version: V1.0
 */
public class Area {
    private String name;
    private String code;
    private String cityCode;

    public Area(String name, String code, String cityCode) {
        this.name = name;
        this.code = code;
        this.cityCode = cityCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
