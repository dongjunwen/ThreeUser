package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/3/9 10:58
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class SysRoleResourceCondDto extends PageDto {
    private String roleCode;
    private String roleName;
    private String sourceNo;
    private String sourceName;
    private String psourceNo;
}
