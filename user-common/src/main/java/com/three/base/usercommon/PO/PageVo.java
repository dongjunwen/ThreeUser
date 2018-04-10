package com.three.base.usercommon.PO;

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
    private Integer pageNum=1;
    /**
     * 每页显示条数 默认50条
     */
    private Integer pageSize=50;

    private String sort;

    private String orderBy;
}
