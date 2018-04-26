package com.ctj.annotationTest;

import java.lang.annotation.*;


@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DatasourceAnnotation {
    String datasourceName();
    int sequence();
}
