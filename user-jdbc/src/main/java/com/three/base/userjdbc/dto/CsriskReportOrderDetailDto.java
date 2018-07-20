package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/3/5 17:10
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class CsriskReportOrderDetailDto extends PageDto {
    private String merNo;
    private String orderType;
    private String ruleCode;
    private String tradeBeginTime;
    private String tradeEndTime;
}
