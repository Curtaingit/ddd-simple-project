package com.curtain.domaindrivendesign.controller;

import cn.wzvtcsoft.validator.anntations.DomainRule;
import cn.wzvtcsoft.validator.anntations.MutationValidated;
import com.curtain.domaindrivendesign.domain.User;

import com.curtain.domaindrivendesign.service.UserService;
import graphql.annotation.GraphqlController;
import graphql.annotation.GraphqlMutation;
import graphql.annotation.SchemaDocumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Curtain
 * @date 2018/11/19 14:20
 */
@GraphqlController("user")
@RestController
@MutationValidated
public class UserController {

    @Autowired
    private UserService userService;

    @SchemaDocumentation("添加用户")
    @GraphqlMutation(path = "/add")
    public User add(@DomainRule(value = "phone && nickname && password") User user){
        return userService.save(user);
    }

    @SchemaDocumentation("用户注册")
    @GraphqlMutation(path = "/register")
    public User register(@DomainRule(value = "phone && nickname && password") User user){
        return userService.register(user);
    }

    @SchemaDocumentation("修改用户")
    @GraphqlMutation("/update")
    public User update(User user){
        return userService.update(user);
    }




}
