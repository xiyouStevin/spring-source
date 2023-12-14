package com.xiyou.spring;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author: Steven
 * @create: 2023-12-14 18:16
 * @Description:
 */
public class InputStreamResourceDemo {
    public static void main(String[] args) throws Exception {
        InputStream isSource = new ByteArrayInputStream("Hello, world!".getBytes());
        Resource resource = new InputStreamResource(isSource);
        try(InputStream is = resource.getInputStream()) {
            System.out.println(new String(is.readAllBytes()));
        }
    }
}
