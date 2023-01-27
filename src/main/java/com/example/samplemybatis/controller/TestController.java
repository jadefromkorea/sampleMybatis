package com.example.samplemybatis.controller;

import com.example.samplemybatis.entity.LeaveCode;
import com.example.samplemybatis.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("searchLeaveCde")
    @ResponseBody
    public List Test(LeaveCode leaveCode) {

        List<LeaveCode> leaveCodeList = testService.selectLeaveCodeList(leaveCode);

        return leaveCodeList;
    }
}
