package com.curtain.domaindrivendesign.repository;


import com.curtain.domaindrivendesign.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Curtain
 * @date 2018/10/9 15:38
 */
public interface PrivilegeRepository extends JpaRepository<Privilege,String> {
}
