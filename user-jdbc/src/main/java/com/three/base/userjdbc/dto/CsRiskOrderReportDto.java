package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @Author:luiz
 * @Date: 2018/2/28 16:34
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class CsRiskOrderReportDto extends PageDto{
    private String orderType;
    private String riskType;
    private String riskLevel;
    private String orderStatus;
    private String ruleCode;
    private String bizCode;
    private String tradeBeginDate;
    private String tradeEndDate;
    private BigDecimal tradeBeginAmt;
    private BigDecimal tradeEndAmt;
}
