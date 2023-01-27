package com.example.samplemybatis.service;

import com.example.samplemybatis.entity.LeaveCode;

import java.util.List;

public interface TestService {
    public List<LeaveCode> selectLeaveCodeList(LeaveCode leaveCode);
}
