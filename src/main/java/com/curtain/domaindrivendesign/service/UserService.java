package com.curtain.domaindrivendesign.service;

import com.curtain.domaindrivendesign.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Curtain
 * @date 2018/11/19 10:45
 */
public interface UserService extends UserDetailsService {

    /**
     * 普管理员添加用户
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 普通用户注册
     *
     * @param user
     * @return
     */
    User register(User user);

    /**
     * 修改
     * @param user
     * @return
     */
    User update(User user);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    User findOne(String id);
}
