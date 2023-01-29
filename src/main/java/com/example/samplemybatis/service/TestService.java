package com.example.samplemybatis.service;

import com.example.samplemybatis.entity.LeaveCode;

import java.util.List;
import java.util.Map;

public interface TestService {
    public List<LeaveCode> selectLeaveCodeList(LeaveCode leaveCode);

    public List<Map<String, String>> test1();
}
