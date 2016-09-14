package com.ctj.services.impl;

import com.ctj.mappers.user.UserMapper;
import com.ctj.pojos.user.User;
import com.ctj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by tingjie.cao on 2016/9/13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        Condition condition = new Condition(User.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userName",userName.trim());
        return userMapper.selectByCondition(condition).get(0);
    }
}
