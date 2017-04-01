package com.zhukm.api.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by king on 2017/3/26.
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -8952121588400710083L;
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
