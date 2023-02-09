package com.example.samplemybatis.service;

import com.example.samplemybatis.entity.UserInfo;
import com.example.samplemybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserInfo createUser(String username, String email, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setEmail(email);

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        userInfo.setPassword(passwordEncoder.encode(password));

        userInfo.setPassword(passwordEncoder.encode(password));

//        this.userRepository.save(user);

        userMapper.createUser(userInfo);

        return userInfo;
    }
}
