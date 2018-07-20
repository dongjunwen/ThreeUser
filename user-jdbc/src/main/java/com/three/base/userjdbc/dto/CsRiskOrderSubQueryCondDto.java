package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/1/31 11:22
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class CsRiskOrderSubQueryCondDto extends PageDto {
    private String merOrderNo;
    private String merNo;
    private String reqOrderNo;
    private String orderType;
    private String orderStatus;
    private String subOrderStatus;
    private String ruleCode;
    /**
     *  开始时间
     */
    private String riskBeginDate;
    /**
     * 结束时间
     */
    private String riskEndDate;

}
