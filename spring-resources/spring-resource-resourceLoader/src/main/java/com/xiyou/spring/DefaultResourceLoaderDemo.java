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
        /**
         * D:/A/B/B/myfile.txt这个是绝对路径，如果工作目录是D:/,那么相对路径就为./A/B/C/myfile.txt
         * 如果我的工作目录是D:/A,那么相对路径就是./B/C/myfile.txt
         * 如果我的龚总目录是D:/A/B/C/222.txt，那么相关路径表示为.../222.txt
         */
        Resource fileResource = loader.getResource("https://github.com/xiyouStevin/spring-source/blob/resource_code/spring-resources/spring-resource-resourceLoader/src/main/myfile.txt");
        System.out.println("文件是否存在 = " + fileResource.exists());

        Resource filesResource = loader.getResource("file:D:\\code\\github\\spring-source\\spring-resources\\spring-resource-resourceLoader\\src\\main\\myfile.txt");
        System.out.println("文件是否存在 = " + filesResource.exists());
    }
}
