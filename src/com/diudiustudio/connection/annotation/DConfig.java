package com.diudiustudio.connection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.android.volley.Request.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DConfig {
	int index();

	int method() default Method.GET;

	String url();

	Class clazz();

}
