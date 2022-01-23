package com.mygroup.myproject.exception;

/**
 * @ClassName: BusinessAException
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/19
 * @Version 1.0
 */
public class BusinessAException extends RuntimeException {

    private static final long serialVersionUID = -4222617976832616419L;

    public BusinessAException() {
        super();
    }

    private String message;

    public BusinessAException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
