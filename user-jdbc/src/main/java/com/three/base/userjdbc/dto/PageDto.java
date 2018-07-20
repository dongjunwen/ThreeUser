package com.three.base.userjdbc.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/1/31 14:34
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class PageDto {
    //第N页
    private int pageNum;
    //每页显示行数
    private int pageSize;
}
