package com.joker.xml.operate;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * 读DOM
 *
 * @Author: wzp
 * @Date: 2020/8/26 22:54
 */
public class XMLReaderTest {

    public static void main(String[] args) throws Exception {
        //1
        String path = XMLReaderTest.class.getResource("/demo.xml").getPath();
//        String path2=XMLReader.class.getClassLoader().getResource("demo1.xml").getPath();
//        System.out.println(path);
//        System.out.println(new File("").getCanonicalPath());
        //1.读取文件
        SAXReader reader = new SAXReader();
        //2.读取文档对象
        Document document = reader.read(new File(path));
//        //打印文档节点类型名称及节点标识
//        System.out.println(document.getNodeTypeName());
//        System.out.println(document.getNodeType());
        //3.读取根标签
        Element rootEle = document.getRootElement();
//        //打印元素节点类型名称及节点标识
//        System.out.println(rootEle.getName());
//        System.out.println(rootEle.getNodeTypeName());
//        System.out.println(rootEle.getNodeType());
        //4.获取子节点
        //4.1根据节点名称，找到对应的某一个节点
//        Element ele3 = rootEle.element("ele3");
//        System.out.println(ele3.getName());
        //4.2 获取所有的儿子节点
        List<Element> ele1_3 = rootEle.elements();
//        List<Element> ele1_3 = rootEle.elements("ele3");
//        System.out.println(ele1_3.size());
        for(Element ele :ele1_3){
//            Attribute attr=ele.attribute("id");
//            System.out.println(attr.getName());
//            System.out.println(attr.getNodeTypeName());
//            System.out.println(attr.getNodeType());
            System.out.println(ele.nodeCount());
        }


    }
}
