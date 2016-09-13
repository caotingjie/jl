package com.ctj.services.impl;

import com.ctj.dao.user.UserDao;
import com.ctj.pojos.user.User;
import com.ctj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tingjie.cao on 2016/9/13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
}
