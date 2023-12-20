package com.xiyou.spring.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: Steven
 * @create: 2023-12-20 17:27
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "";
}
