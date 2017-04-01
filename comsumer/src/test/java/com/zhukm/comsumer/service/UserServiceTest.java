package com.zhukm.comsumer.service;

import com.zhukm.api.domain.User;
import com.zhukm.api.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by king on 2017/3/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    IUserService userService;

    @Test
    public void testFindAll(){
        List<User> all = userService.findAll();
        System.out.println(all);
    }
}
