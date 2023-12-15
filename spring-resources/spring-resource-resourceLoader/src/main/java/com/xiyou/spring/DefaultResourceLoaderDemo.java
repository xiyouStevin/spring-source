package com.xiyou.spring;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * @author: Steven
 * @create: 2023-12-15 17:57
 * @Description:
 */
public class DefaultResourceLoaderDemo {
    public static void main(String[] args) throws Exception {
        DefaultResourceLoader loader = new DefaultResourceLoader();
        //从类路径加载资源
        Resource classResource = loader.getResource("classpath:application.properties");
        System.out.println("类是否存在 = " + classResource.exists());

        //加载文件系统中的资源
        Resource fileResource = loader.getResource("file:/spring-source/spring-resources/spring-resource-resourceLoader/myfile.txt");
        System.out.println("文件是否存在 = " + fileResource.exists());
    }
}
