package com.mygroup.myproject.exception;

import java.util.function.Predicate;

/**
 * @ClassName: RecordFailurePredicate
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/19
 * @Version 1.0
 */
public class RecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        if (throwable.getCause() instanceof BusinessAException) return false;
        else return true;
    }
}