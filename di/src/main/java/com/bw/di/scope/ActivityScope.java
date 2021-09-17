package com.bw.di.scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

/**
 * @ClassName ActivityScope
 * @Author 孔晨亮
 * @Date 2021/9/16 18:58
 * User: msi
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface ActivityScope {
}
