package com.example.samplemybatis.controller;

import com.example.samplemybatis.entity.LeaveCode;
import com.example.samplemybatis.service.TestService;
import com.example.samplemybatis.service.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {
//    @Autowired
//    private TestService testService;

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }


    @PostMapping("searchLeaveCode")
    @ResponseBody
    public List Test(@RequestBody LeaveCode leaveCode) {
        log.info(">>>>> leaveCode: {}", leaveCode);

        List<LeaveCode> leaveCodeList = testService.selectLeaveCodeList(leaveCode);

        return leaveCodeList;
    }



    @GetMapping("getHtml")
    public String getHtml(Model model) {

//        List<LeaveCode> leaveCodeList = testService.selectLeaveCodeList(null);
//
//        int size = leaveCodeList.size();
//        log.info(">>>>> size: " + size);

        List<Map<String, String>> test1 = testService.test1();

        int size = test1.size();
        log.info(">>>>> size: " + size);

        model.addAttribute("size", size);
        model.addAttribute("test1", test1);

        return "sample";
    }



    @GetMapping("test1")
    @ResponseBody
    public List<Map<String, String>> Test1() {
        log.info(">>>>> test1 Controller <<<<<");

        List<Map<String, String>> test1 = testService.test1();

//        JdbcUtils.convertUnderscoreNameToPropertyName(test1)

        return test1;
    }



}
