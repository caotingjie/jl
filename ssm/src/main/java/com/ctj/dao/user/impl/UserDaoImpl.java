package com.ctj.dao.user.impl;

import com.ctj.dao.user.UserDao;
import com.ctj.mappers.user.UserMapper;
import com.ctj.pojos.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by tingjie.cao on 2016/9/13.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByUserName(String userName) {
        Condition condition = new Condition(User.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userName",userName.trim());
        return userMapper.selectByCondition(condition).get(0);
    }
}
