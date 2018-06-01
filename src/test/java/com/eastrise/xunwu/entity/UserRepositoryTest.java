package com.eastrise.xunwu.entity;

import com.eastrise.xunwu.ApplicationTests;
import com.eastrise.xunwu.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by gzq on 2018/6/1 15:11
 */
public class UserRepositoryTest extends ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne(){
        User user = userRepository.findOne(1L);
        Assert.assertEquals("waliwali",user.getName());
    }
}
