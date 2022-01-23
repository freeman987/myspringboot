package com.mygroup.myproject.exception;

/**
 * @ClassName: BusinessBException
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/19
 * @Version 1.0
 */
public class BusinessBException  extends RuntimeException{
    private static final long serialVersionUID = 7608373161392625016L;

    public BusinessBException() {
        super();
    }

    private String message;

    public BusinessBException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
