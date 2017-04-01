package com.zhukm.provider.service.impl;

import com.zhukm.api.domain.User;
import com.zhukm.api.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by king on 2017/3/26.
 */
@Service
public class UserService implements IUserService {
    public List<User> findAll() {
        List<User> userList = Arrays.asList(new User("aa",10), new User("bb",12));
        return userList;
    }
}
