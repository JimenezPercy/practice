package com.joker.xml.operate;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 写XML
 *
 * @Author: wzp
 * @Date: 2020/8/27 6:43
 */
public class XMLWriterTest {
    public static void main(String[] args) throws Exception {
        //新建
        //1.创建文档
        Document document = DocumentHelper.createDocument();
        //2.创建元素
        Element root=DocumentHelper.createElement("root");
        document.add(root);
        //3.创建子节点
        Element ele1=DocumentHelper.createElement("ele1");
        //4.创建属性
        DocumentHelper.createAttribute(ele1,"id","1");
        DocumentHelper.createAttribute(ele1,"name","test1");
        //5.添加文本
        ele1.addText("test1 value...");
        //6.把子节点加入到根节点
        root.add(ele1);
        //7.写文件
        //7.1 文件格式化
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        //7.2
        String path = XMLWriterTest.class.getResource("/").getPath();
        OutputStream out=new FileOutputStream(new File(path,"demo1.xml"));
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(document);
        writer.close();
    }
}
