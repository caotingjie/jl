package com.ctj.jdkAnalysis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AJie on 2017/6/5.
 * 测试泛型擦除
 */
public class GenericTest1<T extends TestB> {
    private Class<T> kind;
    private T test;
    public GenericTest1(Class<T> kind){
        this.kind = kind;
        try {
            test = kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    T[] creat(int size){
        return (T[]) Array.newInstance(kind,size);
    }


    public static void main(String[] args) {
        //GenericTest1<Integer> genericTest1 = new GenericTest1<Integer>(Integer.class);
        //Integer[] creat = genericTest1.creat(9);
        //System.out.println(Arrays.toString(creat));
        //out [null, null, null, null, null, null, null, null, null]

        GenericTest1<TestB> genericTest2 = new GenericTest1<TestB>(TestB.class);
        genericTest2.test.A();

        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
class TestA{
    void A(){
        System.out.println("AAAAAAAAAAAAAAAAAAAAa");
    }
}

class TestB{
    void A(){
        System.out.println("AAAAAAAAAAAABBBBBBBB");
    }
    void B(){
        System.out.println("BBBBBBBBBBBBBBBBBB");
    }
}
