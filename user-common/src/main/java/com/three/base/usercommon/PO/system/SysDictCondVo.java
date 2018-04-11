package com.three.base.usercommon.PO.system;

import com.three.base.usercommon.PO.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @Date:2017/10/24 0024 13:50
 * @Author lu.dong
 * @Description：
 **/
@Data
@ApiModel(value = "数据字典Vo SysDictCondVo")
public class SysDictCondVo extends PageVo{

    @Length(max = 32,message = "字典类型长度不能超过32")
    @ApiModelProperty(value = "字典类型",required =false )
    private String dictType;
    @Length(max = 32,message = "字典代码长度不能超过32")
    @ApiModelProperty(value = "字典代码",required =false )
    private String dictCode;
    @Length(max = 64,message = "字典名称长度不能超过64")
    @ApiModelProperty(value = "字典名称",required =false )
    private String dictName;
    @Length(max = 128,message = "字典值长度不能超过128")
    @ApiModelProperty(value = "字典值",required =false )
    private String dictValue;
    @Length(max = 32,message = "上级字典代码长度不能超过32")
    @ApiModelProperty(value = "上级字典代码",required =false )
    private String fhDictCode;



}
