package com.three.base.usercommon.vo;

import lombok.Getter;
import lombok.Setter;


/**
 * @Author:luiz
 * @Date: 2018/1/31 11:35
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
public class PageVo {
    /**
     * 第N页
     */
    private int pageNum;
    /**
     * 每页显示条数 默认50条
     */
    private int pageSize=50;
}
