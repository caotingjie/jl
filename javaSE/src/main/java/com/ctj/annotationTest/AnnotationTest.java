package com.ctj.annotationTest;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {
    private void handleFieldAnnotation() throws NoSuchFieldException {
        Field datasourceName = UserService.class.getField("datasourceName");//获取属性
        if (datasourceName.isAnnotationPresent(DatasourceAnnotation.class)) {//判断属性上有无此注解
            DatasourceAnnotation annotation = datasourceName.getAnnotation(DatasourceAnnotation.class);//获取注解
            System.out.println(annotation.datasourceName());
            System.out.println(annotation.sequence());
        }
    }

    private void handleMethodAnnotation() throws NoSuchMethodException {
        Method selectUserNameById = UserService.class.getMethod("selectUserNameById", Integer.class);
        if (selectUserNameById.isAnnotationPresent(DatasourceAnnotation.class)) {
            DatasourceAnnotation annotation = selectUserNameById.getAnnotation(DatasourceAnnotation.class);
            System.out.println(annotation.datasourceName());
            System.out.println(annotation.sequence());
        }
    }


    @Test
    public void test() throws Exception {
        //handleFieldAnnotation();
        //handleMethodAnnotation();
        Method test = SubUseInheritedAnnotation.class.getMethod("test", null);
        InheritedAnnotation annotation = test.getAnnotation(InheritedAnnotation.class);
        //InheritedAnnotation annotation = SubUseInheritedAnnotation.class.getAnnotation(InheritedAnnotation.class);
        System.out.println(annotation.name());
    }
}
