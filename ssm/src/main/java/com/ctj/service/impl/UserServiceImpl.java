package com.ctj.service.impl;

import com.ctj.mapper.UserMapper;
import com.ctj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tingjie.cao on 2016/9/13.
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;


    @Override
    public String getUserNameById(Integer id) {
        String userName = userMapper.getUserNameById(id);
        logger.info("userName: "+userName);
        return userName;
    }
}
