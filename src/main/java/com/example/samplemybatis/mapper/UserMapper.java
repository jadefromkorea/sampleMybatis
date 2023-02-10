package com.example.samplemybatis.mapper;

import com.example.samplemybatis.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public UserInfo selectUser(String username);

    public int createUser(UserInfo userInfo);
}
