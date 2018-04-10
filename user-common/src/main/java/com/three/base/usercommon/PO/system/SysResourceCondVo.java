package com.three.base.usercommon.PO.system;

import com.three.base.usercommon.PO.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;

/**
 * @Date:2017/10/23 0023 14:39
 * @Author lu.dong
 * @Description：
 **/
@Getter
@Setter
@ApiModel(value = "资源操作实体 SysResourceVo")
public class SysResourceCondVo extends PageVo{

    @ApiModelProperty(value = "资源代码",required =false )
    private String sourceNo;
    @ApiModelProperty(value = "资源名称",required =false )
    private String sourceName;
    @ApiModelProperty(value = "上级资源代码",required =false )
    private String fhSourceNo;
    @ApiModelProperty(value = "资源类型",required =false )
    private String sourceType;



}
