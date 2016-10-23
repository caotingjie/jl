package com.ctj.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by AJie on 2016/10/11.
 */
public class Dom4jXMLTest {
    @Test
    public void tests() throws FileNotFoundException, DocumentException {
        SAXReader reader = new SAXReader();
        String path = this.getClass().getResource("/").getPath()+"testXML/testXML.xml";
        System.out.println(path);
        Document dom = reader.read(new FileInputStream(path));
        Element node = dom.getRootElement();//获取根元素

        listNodes(node);//遍历元素

    }


    public void listNodes(Element node){
        List<Element> list1 = node.elements();
        for(Element ele : list1){
            System.out.println(ele.getName()+"........."+ele.getData());
            listNodes(ele);
        }
    }
}
