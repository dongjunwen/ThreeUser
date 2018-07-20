package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/2/6 13:27
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class CsRiskDictQueryCondDto extends PageDto {
    private String dictCode;

    private String dictName;

    private String dictValue;

    private String pdictCode;

    private String dictValueType;

    private String isValid;

    private String extendParams;

    private String dictDesc;
}
