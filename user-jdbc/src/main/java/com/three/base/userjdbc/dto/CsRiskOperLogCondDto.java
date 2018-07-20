package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/2/27 15:25
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class CsRiskOperLogCondDto extends PageDto {
    private String userNo;
    private String userName;
    private String operAction;
    private String operBeginTime;
    private String operEndTime;
}
