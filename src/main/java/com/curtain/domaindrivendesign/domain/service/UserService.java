package com.curtain.domaindrivendesign.domain.service;

import com.curtain.domaindrivendesign.domain.User;
import com.curtain.domaindrivendesign.exception.DDDException;
import org.springframework.stereotype.Service;

/**
 * 用户领域服务
 * @author Curtain
 * @date 2018/12/14 9:06
 */
@Service
public class UserService {

    /**
     * 修改密码
     * @param user
     * @param oldPassword
     * @param newPassword
     * @return
     */
    User changePassword(User user, String oldPassword,String newPassword){
        boolean agree = user.getPassword().equals(oldPassword);
        if (agree){
            //验证新密码是否符合规则
            if(newPassword!=null&&newPassword.length()>6){
                user.setPassword(newPassword);
                return user;
            }
            throw new DDDException("新密码不符合规则，修改密码失败");
        }
        throw new DDDException("旧密码不正确，修改密码失败");
    }
}
