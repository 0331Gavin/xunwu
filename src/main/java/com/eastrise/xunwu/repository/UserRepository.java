package com.eastrise.xunwu.repository;

import com.eastrise.xunwu.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * create by gzq on 2018/6/1 15:00
 */
public  interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String userName);

    User findUserByPhoneNumber(String telephone);
}
