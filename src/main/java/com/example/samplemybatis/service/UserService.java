package com.example.samplemybatis.service;

import com.example.samplemybatis.entity.UserInfo;

public interface UserService {
    public UserInfo createUser(String username, String email, String password);
}
