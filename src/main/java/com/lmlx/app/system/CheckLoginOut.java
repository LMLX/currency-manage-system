package com.lmlx.app.system;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jiahao jin
 * @create 2020-12-30 10:56
 */

@Target({ElementType.METHOD})// 可用在方法名上
@Retention(RetentionPolicy.RUNTIME)// 运行时有效
public @interface CheckLoginOut {
    boolean value() default true;
}
