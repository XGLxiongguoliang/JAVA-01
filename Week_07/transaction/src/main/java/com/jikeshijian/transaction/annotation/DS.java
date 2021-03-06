package com.jikeshijian.transaction.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DS {
    String value() default "test1";
}
