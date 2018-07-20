package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/2/12 17:00
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class CsRiskAuditQueryCondDto extends PageDto{
    private String auditNo;
    private String createNo;
    private String auditStatus;
    private String merOrderNo;
    private String payOrderNo;
    private String merNo;
    private String createBeginDate;
    private String createEndDate;
    private String modiBeginDate;
    private String modiEndDate;
}
