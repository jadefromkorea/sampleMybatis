package com.example.samplemybatis.controller;

import com.example.samplemybatis.entity.LeaveCode;
import com.example.samplemybatis.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("searchLeaveCode")
    @ResponseBody
    public List Test(@RequestBody LeaveCode leaveCode) {

        List<LeaveCode> leaveCodeList = testService.selectLeaveCodeList(leaveCode);

        return leaveCodeList;
    }



    @GetMapping("getHtml")
    public String getHtml(Model model) {

        List<LeaveCode> leaveCodeList = testService.selectLeaveCodeList(null);

        int size = leaveCodeList.size();
        log.info(">>>>> size: " + size);

        model.addAttribute("size", size);

        return "sample";
    }



    @GetMapping("test1")
    @ResponseBody
    public List<Map<String, String>> Test1() {
        log.info(">>>>> test1 <<<<<");

        List<Map<String, String>> test1 = testService.test1();

        return test1;
    }



}
