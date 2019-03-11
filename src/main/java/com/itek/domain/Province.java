package com.itek.domain;

/**
 * Class: Province
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/816:11
 * Version: V1.0
 */
public class Province {
    private String name;
    private String code;

    public Province(String name, String code) {
        this.name = name;
        this.code = code;
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
}
