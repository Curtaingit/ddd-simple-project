package com.curtain.domaindrivendesign.repository;


import com.curtain.domaindrivendesign.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * @author Curtain
 * @date 2018/10/9 15:37
 */
public interface RoleRepository extends JpaRepository<Role,String> {
    /**
     * 通过名称查询
     * @param name
     * @return
     */
    Optional<Role> findByName(String name);
}
