package com.mygroup.myproject.exception;
import lombok.Getter;


/**
 * 需要继承RuntimeException。
 * 另外Spring 对于 RuntimeException类型的 异常才会进行事务回滚
 * @author
 *
 */
public class MyCustomException extends RuntimeException {
    private static final long serialVersionUID = 8863339790253662109L;

    @Getter
    private int code ;

    @Getter
    private String message;

    public MyCustomException() {
        super();
    }

    public MyCustomException(int code , String message) {
        this.message = message;
        this.code = code;
    }

}

