package com.ctj.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author caotingjie
 */
@Component
public interface UserMapper {
    String getUserNameById(@Param("id") Integer id);
}