package com.example.samplemybatis.service;

import com.example.samplemybatis.entity.LeaveCode;
import com.example.samplemybatis.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<LeaveCode> selectLeaveCodeList(LeaveCode leaveCode) {
        return testMapper.selectLeaveCodeList(leaveCode);
    }
}
