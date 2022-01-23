package com.mygroup.myproject.exceptionhandle;
import com.mygroup.myproject.exception.BadRequestException;
import com.mygroup.myproject.exception.ExceptionResponseEntity;
import com.mygroup.myproject.exception.MyCustomException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 @ControllerAdvice 捕获 Controller 层抛出的异常，如果添加 @ResponseBody 返回信息则为JSON 格式。
 @RestControllerAdvice 相当于 @ControllerAdvice 与 @ResponseBody 的结合体。
 @ExceptionHandler 统一处理一种类的异常，减少代码重复率，降低复杂度。
 因为我们这里全部异常信息都约定返回json，所以直接使用 @RestControllerAdvice 代替 @ControllerAdvice ，这样在方法上就可以不需要添加 @ResponseBody了
 步骤：
 1.创建一个 GlobalExceptionHandler 类，并添加上 @RestControllerAdvice 注解就可以实现异常通知类的定义了
 2.定义的方法中添加上 @ExceptionHandler 即可实现Controller层的异常捕捉
 *
 */

@Slf4j
@RestControllerAdvice
//@RestController
//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //@ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String handle1(Exception e){
        return "异常了，Exception请检查";
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)//不加这个注解，默认所有的都是200
    @ExceptionHandler(value= RuntimeException.class)
    public String handle2(){
      return "异常了，RuntimeException请检查";
    }

//
//    /**
//     * 如果需要捕获多个异常   定义如下：@ExceptionHandler({})
//     *
//     * @param request
//     * @param e
//     * @param response
//     * @return
//     */
//    // 捕获多个异常的写法
//    @ExceptionHandler({MyCustomException.class, BadRequestException.class})
//    public ExceptionResponseEntity customExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        MyCustomException exception = (MyCustomException) e;
//        log.info("MyCustomException");
//        return new ExceptionResponseEntity(exception.getCode(), exception.getMessage());
//    }
//
//    /**
//     *  捕获  RuntimeException 异常
//     *  如果在一个 exceptionHandler 通过  if (e instanceof xxxException) 太麻烦，
//     *  可以写多个方法标注@ExceptionHandler处理不同的异常
//     *
//     * @param request  request
//     * @param e        exception
//     * @param response response
//     * @return 响应结果
//     */
//    @ExceptionHandler(RuntimeException.class)
//    public ExceptionResponseEntity runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
//        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        RuntimeException exception = (RuntimeException) e;
//        log.info("RuntimeException");
//        return new ExceptionResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
//    }



//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({ConstraintViolationException.class,
//            HttpRequestMethodNotSupportedException.class, IllegalStateException.class})
//    public <T>ResponseBase<T> handleConstraintViolationException(Exception e) {
//        return ResponseBase.failed(ApiCode.INVALID_PARAMETER, e.getMessage());
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(value = Exception.class)
//    public <T>ResponseBase<T> handleException(Exception e) {
//        return ResponseBase.failed(ApiCode.INTERNAL_SERVER_ERROR, e.getMessage());
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public <T>ResponseBase<T> handleParamException(MethodArgumentNotValidException e) {
//        BindingResult bindingResult = e.getBindingResult();
//        return ResponseBase.failed(ApiCode.CHECK_FAIL, bindingResult.getFieldError().getDefaultMessage());
//    }

}
