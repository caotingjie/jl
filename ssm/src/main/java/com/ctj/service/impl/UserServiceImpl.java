package com.ctj.service.impl;

import com.ctj.common.annotation.DataSourceChange;
import com.ctj.mapper.UserMapper;
import com.ctj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tingjie.cao on 2016/9/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    @DataSourceChange(slave = true)
    public String getUserNameById(Integer id) {
        return userMapper.getUserNameById(id);
    }
}
