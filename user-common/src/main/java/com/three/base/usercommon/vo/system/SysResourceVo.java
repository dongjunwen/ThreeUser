package com.three.base.usercommon.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@ToString
@ApiModel(value = "资源操作实体 SysResourceVo")
public class SysResourceVo  {
    private String id;
    @NotBlank(message = "资源代码不能为空")
    @Length(min = 1,max = 32,message = "资源代码长度不能超过32")
    @ApiModelProperty(value = "资源代码",required =true )
    private String sourceNo;
    @Length(max = 64,message = "资源名称长度不能超过64")
    @ApiModelProperty(value = "资源名称",required =false )
    private String sourceName;
    @Length(max = 32,message = "上级资源代码长度不能超过32")
    @ApiModelProperty(value = "上级资源代码",required =false )
    private String psourceNo;
    @Length(max = 16,message = "资源上级资源代码长度不能超过16")
    @ApiModelProperty(value = "资源类型",required =false )
    private String sourceType;
    @Length(max = 512,message = "请求路径长度不能超过512")
    @ApiModelProperty(value = "请求路径",required =false )
    private String reqUrl;
    @Length(max = 64,message = "资源图标长度不能超过64")
    @ApiModelProperty(value = "资源图标",required =false )
    private String sourceIcon;
    @Max(65536)
    @ApiModelProperty(value = "排序",required =false )
    private String sortOrder;
    @Length(max = 1,message = "是否显示长度不能超过1")
    @ApiModelProperty(value = "是否显示 Y:显示 N:不显示",required =false )
    private String ifVisible;
    @Max(65536)
    @ApiModelProperty(value = "级别",required =false )
    private Integer sourceLevel;
    @Length(max = 64,message = "备注长度不能超过64")
    @ApiModelProperty(value = "备注",required =false )
    private String memo;

    private String operNo;


}
