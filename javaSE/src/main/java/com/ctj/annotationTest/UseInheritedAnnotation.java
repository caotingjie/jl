package com.ctj.annotationTest;

@InheritedAnnotation(name = "test")
public class UseInheritedAnnotation {
    @InheritedAnnotation(name = "methodTest")
    public String test(){
        return "";
    }
}
