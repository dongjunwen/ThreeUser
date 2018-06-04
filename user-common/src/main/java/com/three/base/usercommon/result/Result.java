package com.three.base.usercommon.result;


import com.three.base.usercommon.enums.ResultCode;

import java.io.Serializable;

/**
 * @Date:2017/10/19 0019 17:48
 * @Author lu.dong
 * @Description：
 **/
public class Result<T> implements Serializable{
    /**
     * 返回代码
     */
    private String retCode;
    /**
     * 返回消息
     */
    private String retMsg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 是否成功
     */
    private boolean success;

    public static <T> Result<T> newSuccess(){
        return newSuccess(ResultCode.SUCCESS,null);
    }

    public static <T> Result<T> newSuccess(T data){
        return newSuccess(ResultCode.SUCCESS,data);
    }

    public static <T> Result<T> newSuccess(ResultCode resultCode, T data){
        return new Result<>(resultCode.getCode(),resultCode.getMessage(),true,data);
    }

    public static <T> Result<T> newError(ResultCode resultCode){
        return new Result<>(resultCode.getCode(),resultCode.getMessage(),false,null);
    }
    public static <T> Result<T> newError(String code,String msg){
        return new Result<>(code,msg,false,null);
    }

    public Result<T> setErrorCode(ResultCode resultCode){
        this.success = false;
        this.retCode = resultCode.getCode();
        this.retMsg = resultCode.getMessage();
        return this;
    }

    public Result<T> setError(String code,String msg){
        this.success = false;
        this.retCode = code;
        this.retMsg = msg;
        return this;
    }

    public Result(String code, String message, boolean success, T data) {
        this.retCode = code;
        this.retMsg = message;
        this.data = data;
        this.success = success;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Result{" +
                "retCode='" + retCode + '\'' +
                ", retMsg='" + retMsg + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }
}
