package com.curtain.ddd.service;


import com.curtain.ddd.domain.User;
import com.curtain.ddd.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Curtain
 * @date 2019/2/25 15:42
 */
@Service
public class ApplicationService {

    @Autowired
    private UserService userService;

    public User register(User user){
        //事务控制  权限控制
       return userService.register(user);
    }
}
