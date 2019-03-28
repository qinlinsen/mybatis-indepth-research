package com.timo.xml;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Abraham Qin
 * @since 2019/3/27
 */
public interface FndUserMapper {
    @Select("select user_id from fnd_user")
    List<String> selectUserList();
}
