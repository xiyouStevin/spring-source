package com.xiyou.spring;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author: Steven
 * @create: 2023-12-15 18:12
 * @Description:
 */
public class PathMatchingResourcePatternResolverDemo {
    public static void main(String[] args) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        //加载所有匹配的类路径资源
        Resource[] resources = resolver.getResources("classpath*:*.properties");
        for (Resource resource : resources) {
            System.out.println("类路径 =" + resource.getFilename());
        }

        //加载文件系统中的所有匹配资源
        Resource[] fileResources = resolver.getResources("file:/spring-source/spring-resources/spring-resource-resourceLoader/*.txt");
        for (Resource resource : fileResources) {
            System.out.println("文件系统路径 =" + resource.getFilename());
        }
    }
}
