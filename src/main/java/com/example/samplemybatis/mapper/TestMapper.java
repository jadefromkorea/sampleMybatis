package com.example.samplemybatis.mapper;

import com.example.samplemybatis.entity.LeaveCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    public List<LeaveCode> selectLeaveCodeList(LeaveCode leaveCode);
}
