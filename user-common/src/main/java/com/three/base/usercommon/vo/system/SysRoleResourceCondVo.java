package com.three.base.usercommon.vo.system;

import com.three.base.usercommon.vo.PageVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/3/13 11:29
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class SysRoleResourceCondVo extends PageVo {
    private String roleCode;
    private String roleName;
    private String sourceNo;
    private String sourceName;
    private String psourceNo;
}
