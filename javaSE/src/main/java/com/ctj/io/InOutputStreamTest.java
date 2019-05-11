package com.ctj.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InOutputStreamTest {
    public static void main(String[] args) {
        String s = "20180508";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(df.format(df.parse(s)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
