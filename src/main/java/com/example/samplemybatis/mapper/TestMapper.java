package com.example.samplemybatis.mapper;

import com.example.samplemybatis.entity.LeaveCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {
    public List<LeaveCode> selectLeaveCodeList(LeaveCode leaveCode);

    public List<Map<String, String>> test1();
}
