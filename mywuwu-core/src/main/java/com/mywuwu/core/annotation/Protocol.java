package com.mywuwu.core.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 14:08
 * @Description:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface Protocol {
    int value();
}
