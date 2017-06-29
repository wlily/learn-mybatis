package com.wll.test.mybatis.exception;

/**
 * Created by wll on 17-6-29.
 */
public class AppException  extends RuntimeException {

    public AppException(int errorCode){}

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

}
