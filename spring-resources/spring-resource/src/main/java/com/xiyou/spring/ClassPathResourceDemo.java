package com.xiyou.spring;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;

/**
 * @author: Steven
 * @create: 2023-12-14 17:57
 * @Description: 获取类路径内容
 */
public class ClassPathResourceDemo {
    public static void main(String[] args) throws Exception {
        String path = "application.properties";
        Resource resource = new ClassPathResource(path);
        try (InputStream is = resource.getInputStream()){
            //读取中文时乱码，如何解决？
            String str = new String(is.readAllBytes());
            System.out.println(str);
        }
    }
}
