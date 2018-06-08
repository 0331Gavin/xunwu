package com.eastrise.xunwu.service.user;

import com.eastrise.xunwu.entity.Role;
import com.eastrise.xunwu.entity.User;
import com.eastrise.xunwu.repository.RoleRepository;
import com.eastrise.xunwu.repository.UserRepository;
import com.eastrise.xunwu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * create by gzq on 2018/6/8 17:36
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);
        if(user ==null ){
            return null;
        }
        List<Role> roles = roleRepository.findAllByUserId(user.getId());
        if(roles==null||roles.isEmpty()){
            throw new DisabledException("权限非法");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE+" + role.getName())));
        user.setAuthorityList(authorities);
        return user;
    }
}
