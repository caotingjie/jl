package com.ctj.services;

import com.ctj.pojos.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tingjie.cao on 2016/5/7.
 */
@Service
public interface UserService {
    List<User> getUserList();
}
