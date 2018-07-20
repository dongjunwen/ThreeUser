package com.three.base.usercommon.vo.system;

import com.three.base.usercommon.vo.PageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author:luiz
 * @Date: 2018/3/13 11:11
 * @Descripton:
 * @Modify :
 **/
@Getter
@Setter
@ToString
public class SysUserCondVo extends PageVo {
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    @ApiModelProperty(value = "手机号")
    private String phoneNum;
    @ApiModelProperty(value = "邮箱地址")
    private String emailAddr;

}
