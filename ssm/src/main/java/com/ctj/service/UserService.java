package com.ctj.service;

import org.springframework.stereotype.Service;

/**
 * Created by tingjie.cao on 2016/5/7.
 */
@Service
public interface UserService {
    String getUserNameById(Integer id);
}
