package com.zhukm.api.service;

import com.zhukm.api.domain.User;

import java.util.List;

/**
 * Created by king on 2017/3/26.
 */
public interface IUserService {
    List<User> findAll();
}
