package com.example.samplemybatis.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class TestControllerTest {
    @Test
    void test1() {
        TestRestTemplate restTemplate =  new TestRestTemplate();

        ResponseEntity<String> res = restTemplate.getForEntity("http://localhost:9090/test/test1", String.class);

        System.out.println(">>>>> res: " + res.toString());

        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
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