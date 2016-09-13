package com.ctj.dao.user;

import com.ctj.pojos.user.User;

/**
 * Created by tingjie.cao on 2016/9/13.
 */
public interface UserDao {
    User getUserByUserName(String userName);
}
