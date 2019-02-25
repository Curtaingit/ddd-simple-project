package com.curtain.ddd.controller;


import com.curtain.ddd.domain.User;
import com.curtain.ddd.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Curtain
 * @date 2019/2/25 15:41
 */
@RestController
public class ApplicataionUserController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/register")
    public User register() {
        User user = new User("1","2");
        return applicationService.register(user);
    }
}
