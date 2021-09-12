package com.zhang.mvp_core.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Model
 * @Author 孔晨亮
 * @Date 2021/9/8 19:12
 * User: msi
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Model {

}
