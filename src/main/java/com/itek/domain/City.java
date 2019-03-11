package com.itek.domain;

/**
 * Class: City
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/816:15
 * Version: V1.0
 */
public class City {
    private String name;
    private String code;
    private String provinceCode;

    public City(String name, String code, String provinceCode) {
        this.name = name;
        this.code = code;
        this.provinceCode = provinceCode;
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

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
