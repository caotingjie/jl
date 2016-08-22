package com.ctj.annotationTest;

import java.lang.annotation.*;

/**
 * Created by tingjie.cao on 2016/8/1.
 */
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationSout {
    int wolege();
}
