package com.curtain.domaindrivendesign.exception;

import com.curtain.domaindrivendesign.enums.ResultExceptionEnum;
import graphql.errors.BusinessException;

/**
 * @author Curtain
 * @date 2018/11/19 17:25
 */
public class DDDException extends BusinessException {

    private ResultExceptionEnum resultExceptionEnum;

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    public DDDException(ResultExceptionEnum resultExceptionEnum){
        super(resultExceptionEnum.getMessage(),resultExceptionEnum.getCode());
        this.resultExceptionEnum =resultExceptionEnum;
    }

    public DDDException(String msg){
        super(msg);
    }
}
