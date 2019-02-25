package com.curtain.ddd.domain;



import com.curtain.ddd.common.AssertionConcern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Curtain
 * @date 2019/2/15 14:38
 */
@Entity
@Table(name = "T_user")
public class User {

    private String username;

    private String password;

    @Id
    @GeneratedValue
    private Integer id;


    public void changeUsername(String username) {
        AssertionConcern.assertArgumentNotNull(username,"用户名不能为空");
        this.username = username;
    }

    public void changePassword(String password) {
        AssertionConcern.assertArgumentNotNull(password,"密码不能为空");
        AssertionConcern.assertArgumentLength(password,6,15,"密码长度不正确");
        this.password = password;
    }

    public String username() {
        return this.username;
    }

    public Integer id(){
        return this.id;
    }

    @Override
    public int hashCode() {
        return 45214 * 234 + this.id.hashCode() + this.username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equalObject = false;
        if (obj != null && this.getClass() == obj.getClass()) {
            User typedObject = (User) obj;
            equalObject = this.id.equals(typedObject.id) && this.username.equals(typedObject.username);
        }
        return equalObject;
    }

    public User register(User user){
        //数据验证
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(){

    }
}
