package com.xiyou.spring;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: Steven
 * @create: 2023-12-14 18:10
 * @Description:
 */
public class FileSystemResourceDemo {
    public static void main(String[] args) throws Exception {
        String path = "D:\\doc\\myfile.txt";
        Resource resource = new FileSystemResource(path);
        try(InputStream is = resource.getInputStream()){
            System.out.println(new String(is.readAllBytes()));
        }
    }
}
