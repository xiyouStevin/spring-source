package com.xiyou.spring;

import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

/**
 * @author: Steven
 * @create: 2023-12-19 16:32
 * @Description:
 */
public class DocumentLoaderDemo {
    public static void main(String[] args) throws Exception {
        try {
            //加载类对象
            Resource resource = new ClassPathResource("sample.xml");

            //创建DocumentLoader实例
            DefaultDocumentLoader documentLoader = new DefaultDocumentLoader();

            Document document = documentLoader.loadDocument(new InputSource(resource.getInputStream()), null, null, 0, true);

            //打印 XML 文档中的内容
            printDetailedDocumentInfo(document);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDetailedDocumentInfo(Document document){
        Element rootElement = document.getDocumentElement();
        printElementInfo(rootElement, "");
    }


    /**
     * 递归打印XML元素的详细信息，包括元素名称，属性和子节点
     * @param element 要打印的XML元素
     * @param indent 当前打印的缩进
     */
    private static void printElementInfo(Element element, String indent){
        //打印元素名称
        System.out.println(indent + "元素名称：" + element.getNodeName());

        //打印元素的属性
        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            System.out.println(indent + " 属性：" + attribute.getNodeName() + " 值：" + attribute.getNodeValue());

        }

        //打印元素的子节点
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            if(child.getNodeType() == Node.ELEMENT_NODE){
                Element childElement = (Element) child;
                printElementInfo(childElement, indent + " ");
            }else if(child.getNodeType() == Node.TEXT_NODE){
                System.out.println(indent + " 文本：" + child.getNodeValue().trim());
            }
        }
    }
}
