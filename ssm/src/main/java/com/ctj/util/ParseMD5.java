package com.ctj.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tingjie.cao on 2016/9/13.
 *
 *
 *
 * 前面提到MD5的破解算法，也称为碰撞算法。本质就是对于一个给定的MD5，在很短的时间内就能找到可能的源文件内容。前面提到MD5算法是不可逆的，
 * 也就是说破解算法不能保证得到的一定是源文件内容，但是能保证该文件内容计算出的MD5值一定和源文件产生的MD5相同。我们来看看这有什么危害：
 * 比如用户的登录密码为666666，后台数据库存储的是MD5值，假如是0ca175b9c0f726a831d895e269332461。破解的人拿到这个MD5值，
 * 使用破解算法计算出和这个MD5碰撞的密码，假如是678865。
 *这样破解的人就可以使用678865去登录，由于MD5的输出还是0ca175b9c0f726a831d895e269332461，因此这个人就可以顺利登录。
 *对于这个问题，一个很容易的解决方案是，将用户输入的初始密码复制一份，变成666666666666，然后产生MD5，
 *存入数据库。这样破解算法得到的可能的密码就不再是678865了，他也无法用这个可能密码去登录。
 *除了碰撞算法破解以外，现在被黑客使用最多的一种破译密码的方法就是一种被称为"跑字典"的暴力破解方法(brute force)。有两种方法得到字典，
 *一种是日常搜集的用做密码的字符串表，另一种是用排列组合方法生成的，先用MD5程序计算出这些字典项的MD5值，然后再用目标的MD5值在这个字典中检索。
 *我们假设密码的最大长度为8位字节（8 Bytes），同时密码只能是字母和数字，共26+26+10=62个字符，排列组合出的字典的项数则是P（62,1）+P（62,2）….+P（62,8），
 * 那也已经是一个很天文的数字了，存储这个字典就需要TB级的磁盘阵列，而且这种方法还有一个前提，就是能获得目标账户的密码MD5值的情况下才可以。
 * 这种加密技术被广泛的应用于UNⅨ系统中
 */
public class ParseMD5 {
    /**
     * @param str
     * @return
     * @Date: 2013-9-6
     * @Author: lulei
     * @Description:  32位小写MD5
     */
    public static String parseStrToMd5L32(String str){
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes){
                int bt = b&0xff;
                if (bt < 16){
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    /**
     * @param str
     * @return
     * @Date: 2013-9-6
     * @Author: lulei
     * @Description: 32位大写MD5
     */
    public static String parseStrToMd5U32(String str){
        String reStr = parseStrToMd5L32(str);
        if (reStr != null){
            reStr = reStr.toUpperCase();
        }
        return reStr;
    }

    /**
     * @param str
     * @return
     * @Date: 2013-9-6
     * @Author: lulei
     * @Description: 16位小写MD5
     */
    public static String parseStrToMd5U16(String str){
        String reStr = parseStrToMd5L32(str);
        if (reStr != null){
            reStr = reStr.toUpperCase().substring(8, 24);
        }
        return reStr;
    }

    /**
     * @param str
     * @return
     * @Date: 2013-9-6
     * @Author: lulei
     * @Description: 16位大写MD5
     */
    public static String parseStrToMd5L16(String str){
        String reStr = parseStrToMd5L32(str);
        if (reStr != null){
            reStr = reStr.substring(8, 24);
        }
        return reStr;
    }
}
