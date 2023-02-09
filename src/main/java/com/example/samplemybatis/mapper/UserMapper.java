package com.example.samplemybatis.mapper;

import com.example.samplemybatis.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int createUser(UserInfo userInfo);
}
