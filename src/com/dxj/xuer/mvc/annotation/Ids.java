package com.dxj.xuer.mvc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ��ע���ID�Ĳ������磺"12-23-123-1234"
 * @author <a href="tuziilm@gmail.com">Tuziilm</a>
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ids {
	String value() default "";
}