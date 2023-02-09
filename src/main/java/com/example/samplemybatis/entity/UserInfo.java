package com.example.samplemybatis.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("UserInfo")
public class UserInfo {
    private Long id;

    private String username;

    private String password;

    private String password1;
    private String password2;

    private String email;
}
