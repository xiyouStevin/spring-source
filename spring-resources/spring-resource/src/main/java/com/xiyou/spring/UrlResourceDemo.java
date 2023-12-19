package com.xiyou.spring;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.InputStream;

/**
 * @author: Steven
 * @create: 2023-12-14 18:18
 * @Description:
 */
public class UrlResourceDemo {
    public static void main(String[] args) throws Exception {
        Resource resource = new UrlResource("https://dist.apache.org/repos/dist/test/test.txt");
        try (InputStream is = resource.getInputStream()){
            System.out.println(new String(is.readAllBytes()));
        }
    }
}
