package com.orasi.core.by.mobile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.orasi.core.Beta;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FindByMobile {
  HowMobile howNG() default HowMobile.RESOURCEID;
  String using() default "";
  String resourceId() default "";
}
