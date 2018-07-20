package com.three.base.usercommon.vo.system;

import com.three.base.usercommon.vo.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @Date:2017/10/23 0023 14:39
 * @Author lu.dong
 * @Description：
 **/
@Getter
@Setter
@ToString
@ApiModel(value = "资源操作实体 SysResourceCondVo")
public class SysResourceCondVo extends PageVo {
    @ApiModelProperty(value = "资源代码")
    private String sourceNo;
    @ApiModelProperty(value = "资源名称" )
    private String sourceName;
    @ApiModelProperty(value = "上级资源代码")
    private String psourceNo;
}
