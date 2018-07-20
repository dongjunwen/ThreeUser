package com.three.base.userjdbc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author:luiz
 * @Date: 2018/3/9 10:35
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class SysResourceDto {
    private Long id;
    private String sourceNo;

    private String sourceName;

    private String psourceNo;

    private String sourceType;

    private String reqUrl;

    private String sourceIcon;

    private BigDecimal sortOrder;

    private BigDecimal sourceLevel;

    private String ifVisible;

    private String memo;

    private String createNo;

    private Date createTime;

    private String modiNo;

    private Date modiTime;
}
