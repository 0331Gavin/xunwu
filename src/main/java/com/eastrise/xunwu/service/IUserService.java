package com.eastrise.xunwu.service;

import com.eastrise.xunwu.entity.User;

/**
 * 用户服务
 * create by gzq on 2018/6/8 17:34
 * */
public interface IUserService {
    User findUserByName(String userName);
}
