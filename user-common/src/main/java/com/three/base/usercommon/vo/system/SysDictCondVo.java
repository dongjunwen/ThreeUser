package com.three.base.usercommon.vo.system;

import com.three.base.usercommon.vo.PageVo;

/**
 * @Author:luiz
 * @Date: 2018/7/20 16:39
 * @Descripton:
 * @Modify :
 **/
public class SysDictCondVo extends PageVo {
    private String dictType;

    private String dictCode;

    private String dictName;

    private String dictValue;

    private String dictDesc;

    private String fhDictCode;

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    public String getFhDictCode() {
        return fhDictCode;
    }

    public void setFhDictCode(String fhDictCode) {
        this.fhDictCode = fhDictCode;
    }
}
