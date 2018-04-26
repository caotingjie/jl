package com.ctj.annotationTest;


public class UserService {
    @DatasourceAnnotation(datasourceName = "master", sequence = 1)
    public String datasourceName;

    @DatasourceAnnotation(datasourceName = "salve", sequence = 2)
    public String selectUserNameById(Integer id) {
        return "test";
    }
}
