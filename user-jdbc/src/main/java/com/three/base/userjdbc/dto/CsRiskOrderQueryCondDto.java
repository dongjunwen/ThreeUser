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
public class CsRiskOrderQueryCondDto extends PageDto {
    /**
     *  开始时间
     */
    private String riskBeginDate;
    /**
     * 结束时间
     */
    private String riskEndDate;

    private String riskStatus;

}
