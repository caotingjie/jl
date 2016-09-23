package com.ctj.algorithm.tips;

import org.junit.Test;

/**
 * Created by tingjie.cao on 2016/9/23.
 * 把正整数转化成二进制输出
 */
public class IntegerToBinary {
    @Test
    public void test(){
        //方法一
        System.out.println(Integer.toBinaryString(50));


        //方法二
        StringBuilder sb = new StringBuilder();
        int b = 50;
        for(int n = b;n > 0;n = (n/2)){
            int r = n % 2;
            sb.append(r);
        }
        System.out.println(sb.reverse());
    }
}
