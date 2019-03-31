package com.laibao.spring.reactive.exceptions;

import lombok.Data;

@Data
public class CheckException extends RuntimeException{

    private static final long serialVersionUID = -2318483923748966669L;

    public CheckException(String message) {
        super(message);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    protected CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    private String fieldName;

    private String fieldValue;

    public CheckException(String fieldName,String fieldValue) {
        super();
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
