package com.curtain.ddd.domain.service;


import com.curtain.ddd.domain.User;
import com.curtain.ddd.infrastructure.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Curtain
 * @date 2019/2/25 15:28
 */
@Service
public class UserService {

    @Autowired
    private JpaUserRepository userRepository;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public User register(User user) {
        //业务逻辑
        //推送事件
        return userRepository.save(user.register(user));
    }

}
