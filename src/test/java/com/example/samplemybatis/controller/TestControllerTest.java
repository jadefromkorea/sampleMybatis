package com.example.samplemybatis.controller;

import com.example.samplemybatis.entity.LeaveCode;
import com.example.samplemybatis.mapper.TestMapper;
import com.example.samplemybatis.service.TestService;
import com.example.samplemybatis.service.TestServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TestControllerTest {
//    @Autowired
//    private TestMapper testMapper;
//
//    @SpringBootTest
//    void test1() {
//
//    }


//    @Test
//    void test1() {
//        List<Map<String, String>> test1 = new TestController(new TestService() {
//            @Override
//            public List<LeaveCode> selectLeaveCodeList(LeaveCode leaveCode) {
//                return null;
//            }
//
//            @Override
//            public List<Map<String, String>> test1() {
//                return null;
//            }
//        }).Test1();
//
//        Assertions.assertThat(test1).size().isEqualTo("5");
//    }
}