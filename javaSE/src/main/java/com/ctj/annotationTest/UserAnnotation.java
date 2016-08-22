package com.ctj.annotationTest;

/**
 * Created by tingjie.cao on 2016/8/1.
 */
@AnnotationSout(wolege=1)
public class UserAnnotation {
    @AnnotationSout(wolege = 2)
    public int id;
    private String name;

    public UserAnnotation(){}
    @AnnotationSout(wolege = 3)
    public UserAnnotation(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
