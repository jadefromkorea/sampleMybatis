package com.example.samplemybatis.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("LeaveCode")
public class LeaveCode {
    /** 회사 */
    private String compCode;
    /** 휴가코드 */
    private String wrkattCd;
    /** 휴가명 */
    private String wrkattNm;
    /** 사용여부 */
    private String useYn;
    /** 지급방식 */
    private String payDivCd;
    /** 사용자신청여부 */
    private String userReqYn;
    /** 최소사용일수 */
    private int minReqDdCnt;
    /** 최대사용일수 */
    private int maxReqDdCnt;
    /** 년간사용가능일수 */
    private int yrUseDdCnt;
    /** 오전/오후활성여부 */
    private String mrnAftUseYn;
    /** 등록자 */
    private String regId;
    /** 등록일자 */
    private String regDt;
    /** 수정자 */
    private String updId;
    /** 수정일자 */
    private String updDt;
    
    private String rsnIptMstYn;
    
    private double useDdCnt;
    
    private int minUseTm;
    
    private int orderNo;
    
    private String inpVacationName;
    
    private String inpUseType;
    
    private String vacationBoth;
    
}
