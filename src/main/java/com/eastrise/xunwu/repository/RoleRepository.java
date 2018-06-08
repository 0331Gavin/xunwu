package com.eastrise.xunwu.repository;

import com.eastrise.xunwu.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 角色DAO
 * create by gzq on 2018/6/8 17:48
 */
public interface RoleRepository extends CrudRepository<Role,Long>{
    List<Role> findAllByUserId(Long userId);
}
