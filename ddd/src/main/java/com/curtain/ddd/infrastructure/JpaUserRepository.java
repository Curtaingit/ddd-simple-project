package com.curtain.ddd.infrastructure;


import com.curtain.ddd.domain.User;
import com.curtain.ddd.domain.UserReposity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Curtain
 * @date 2019/2/15 14:38
 */
@Repository
public interface JpaUserRepository extends JpaRepository<User,String>, UserReposity {
    User save(User user);
}
