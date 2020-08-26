package com.joker.xml.operate;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * 修改DOM
 * @Author: wzp
 * @Date: 2020/8/27 7:07
 */
public class XMLReviseTest {
    public static void main(String[] args) throws Exception {
        String path = XMLReviseTest.class.getResource("/demo.xml").getPath();

        //1.读取文件
        SAXReader reader = new SAXReader();
        //读取文档对象
        Document document = reader.read(new File(path));
        //读取根标签
        Element rootEle = document.getRootElement();
        //获取子节点
        List<Element> eles=rootEle.elements();

        //2.添加内容
        //2.1直接添加新节点
        Element ele3= DocumentHelper.createElement("ele3");
        eles.add(ele3);
        //2.2追加子节点，要先获取父节点
        //3.写文件
        //文件格式化
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        OutputStream out=new FileOutputStream(new File(path));
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(document);
        writer.close();
    }
}
