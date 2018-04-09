package com.three.base.userweb.validator;

import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.exception.RRException;
import org.apache.commons.lang3.StringUtils;


/**
 * 数据校验
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:50
 */
public abstract class Assert {

    public static void isBlank(String str, String err) {
        if (StringUtils.isBlank(str)) {
           // throw new RRException(err, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
            throw new RRException(ResultCode.COMMON_PARAM_INVALID.getCode(), ResultCode.COMMON_PARAM_INVALID.getMessage());
        }
    }

    public static void isNull(Object object, String err) {
        if (object == null) {
           // throw new RRException(err,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
            throw new RRException(ResultCode.COMMON_PARAM_NULL.getCode(), ResultCode.COMMON_PARAM_NULL.getMessage());
        }
    }
}
