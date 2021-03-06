package com.curtain.domaindrivendesign.service.impl;

import com.curtain.domaindrivendesign.domain.Privilege;
import com.curtain.domaindrivendesign.domain.PrivilegeItem;
import com.curtain.domaindrivendesign.domain.Role;
import com.curtain.domaindrivendesign.domain.User;
import com.curtain.domaindrivendesign.enums.ResultExceptionEnum;
import com.curtain.domaindrivendesign.exception.DDDException;
import com.curtain.domaindrivendesign.repository.RoleRepository;
import com.curtain.domaindrivendesign.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Curtain
 * @date 2018/10/23 16:01
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @PreAuthorize("hasAuthority('C1')")
    public Role save(Role role) {

        //todo 需要校验constraint 是否符合规则 能否转化成qfilter  失败则抛出异常
        //校验角色名是否已经存在
        Optional<Role> result = roleRepository.findByName(role.getName());
        if (result.isPresent()){
            throw new DDDException(ResultExceptionEnum.ROLE_NAME_IS_EXIST);
        }

        role = roleRepository.save(role);
        privilegeCheck(role);

        return role;
    }

    @Override
    @PreAuthorize("hasAuthority('C1')")
    public Role update(Role role) {
        //todo 需要校验constraint 是否符合规则 能否转化成qfilter  失败则抛出异常
        role = roleRepository.save(role);
        privilegeCheck(role);
        return role;
    }

    /**
     * 验证修改的权限 是否被允许（包含在当前用户中）
     * @param role
     */
    private void privilegeCheck(Role role) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Set<Privilege> principalPrivilege = principal.getRoleItems()
                .stream()
                .flatMap(roleItem -> roleItem.getRole().getPrivilegeItems().stream())
                .map(PrivilegeItem::getPrivilege).collect(Collectors.toSet());

        Set<Privilege> rolePrivilege = role.getPrivilegeItems().stream()
                .map(PrivilegeItem::getPrivilege).collect(Collectors.toSet());

        if (!principalPrivilege.containsAll(rolePrivilege)) {
            throw new AccessDeniedException("角色添加错误，赋予了本身不具备的权限");
        }
    }

}
