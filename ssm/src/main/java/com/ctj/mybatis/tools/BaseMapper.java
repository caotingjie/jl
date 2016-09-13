package com.ctj.mybatis.tools;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * Created by tingjie.cao on 2016/9/13.
 */
public interface BaseMapper<T> extends Mapper<T>, ConditionMapper<T>, MySqlMapper<T>,RowBoundsMapper<T> {
}
