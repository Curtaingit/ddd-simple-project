package com.curtain.ddd.domain;

import com.curtain.ddd.domain.User;

/**
 * @author Curtain
 * @date 2019/2/15 14:40
 */
public interface UserReposity {

    User save(User user);
}
