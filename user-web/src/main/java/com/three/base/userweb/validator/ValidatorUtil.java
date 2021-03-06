package com.three.base.userweb.validator;

/**
 * Created by Administrator on 2017/8/9.
 */



import com.three.base.usercommon.enums.ResultCode;
import com.three.base.usercommon.exception.RRException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 *
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-15 10:50
 */
public class ValidatorUtil{
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * 校验对象
     * @param object        待校验对象
     * @throws RRException  校验不通过，则报RRException异常
     */
    public static void validateEntity(Object object){
        if(object==null){
          //  throw new RRException("参数不能为空", HttpStatus.UNPROCESSABLE_ENTITY);
            throw new RRException( ResultCode.COMMON_PARAM_NULL.getCode(),"参数不能为空");
        }

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for(ConstraintViolation<Object> constraint:  constraintViolations){
                if(StringUtils.isNotBlank(msg.toString())){
                    msg.append("\n");
                }
                msg.append(constraint.getMessage());
            }
            throw new RRException( ResultCode.COMMON_PARAM_INVALID.getCode(),msg.toString());
        }
    }
}
