package com.ctj.simpleTest;

import org.junit.Test;

import java.util.*;

public class SimpleTest {
    @Test
    public void test(){
        System.out.println(randomString(-229985452) + " " + randomString(-147909649));

    }

    public String randomString(int i){
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true)
        {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char)('`' + k));
        }

        return sb.toString();
    }
}
