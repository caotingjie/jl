package com.ctj.annotationTest;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by tingjie.cao on 2016/8/1.
 */
public class AnnotationTest {
    public void handleTypeAnnotation() throws ClassNotFoundException {
        Class userAnnotationClass = Class.forName("com.ctj.annotationTest.UserAnnotation");
        Annotation[] annotations = userAnnotationClass.getAnnotations();

        for(Annotation annotation : annotations){
            AnnotationSout annotationSout = (AnnotationSout) annotation;
            System.out.println(annotationSout.wolege());
        }
    }

    public void handleConstructorAnnotation() throws NoSuchMethodException {
        Constructor[] constructors = UserAnnotation.class.getConstructors();
        for(Constructor constructor : constructors){
            if (constructor.isAnnotationPresent(AnnotationSout.class)){
                System.out.println(((AnnotationSout)constructor.getAnnotation(AnnotationSout.class)).wolege());
            }
        }
    }

    public void handleFieldAnnotation() throws NoSuchFieldException {
        Field id =  UserAnnotation.class.getField("id");
        if(id.isAnnotationPresent(AnnotationSout.class)){
            System.out.println(id.getAnnotation(AnnotationSout.class).wolege());
        }
    }


    @Test
    public void test() throws Exception {
        System.out.println(232323);
        handleFieldAnnotation();
        handleTypeAnnotation();
        handleConstructorAnnotation();
    }
}
