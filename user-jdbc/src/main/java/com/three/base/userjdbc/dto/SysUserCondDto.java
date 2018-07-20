package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/3/13 11:13
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class SysUserCondDto extends PageDto {
    private String userName;
    private String phoneNum;
    private String emailAddr;
}
