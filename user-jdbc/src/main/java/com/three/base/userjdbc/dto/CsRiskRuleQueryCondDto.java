package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/2/2 13:28
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class CsRiskRuleQueryCondDto extends PageDto {
    private String ruleCode;
    private String ruleName;
    private String bizCode;
    private String bizName;
    private String ruleType;
    private String ruleStatus;
    private String beginTime;
    private String endTime;
}
