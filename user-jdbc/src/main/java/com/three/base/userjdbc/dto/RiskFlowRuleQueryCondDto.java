package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RiskFlowRuleQueryCondDto extends PageDto{

    //编码代码
    String ruleCode;
    //编码名称
    String ruleName;

}
