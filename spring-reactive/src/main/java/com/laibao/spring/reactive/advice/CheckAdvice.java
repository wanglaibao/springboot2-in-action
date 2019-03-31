package com.laibao.spring.reactive.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

/**
 * 异常处理切面
 */
@ControllerAdvice
public class CheckAdvice {

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity handleBindException(WebExchangeBindException webExchangeBindException) {

        return new ResponseEntity<String>(convertToString(webExchangeBindException), HttpStatus.BAD_REQUEST);
    }


    /**
     * 把校验异常转换成字符串
     * @param webExchangeBindException
     * @return String
     */
    private String convertToString(WebExchangeBindException webExchangeBindException) {
        return webExchangeBindException.getFieldErrors()
                                .stream()
                                .map(e -> e.getField()+" : "+e.getDefaultMessage())
                                .reduce(" ",(str1,str2) -> str1+"\n"+str2);
    }
}
