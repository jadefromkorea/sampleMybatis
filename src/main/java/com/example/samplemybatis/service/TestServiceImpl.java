package com.example.samplemybatis.service;

import com.example.samplemybatis.entity.LeaveCode;
import com.example.samplemybatis.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<LeaveCode> selectLeaveCodeList(LeaveCode leaveCode) {
        log.info(">>>>> selectLeaveCodeList <<<<<");

        return testMapper.selectLeaveCodeList(leaveCode);
    }



    @Override
    public List<Map<String, String>> test1() {
        log.info(">>>>> test1 <<<<<");

        return testMapper.test1();
    }
}
