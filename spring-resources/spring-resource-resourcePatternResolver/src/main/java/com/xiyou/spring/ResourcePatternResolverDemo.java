package com.xiyou.spring;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @author: Steven
 * @create: 2023-12-18 17:41
 * @Description:
 */
public class ResourcePatternResolverDemo {
    public static void main(String[] args) throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        //加载所有匹配的类路径资源
        Resource[] resources = resolver.getResources("classpath:*.properties");
        for (Resource resource : resources) {
            System.out.println("类路径 = " + resource.getFilename());
        }
        Resource[] fileResources = resolver.getResources("https://github.com/xiyouStevin/spring-source/blob/resource_code/spring-resources/spring-resource-resourceLoader/src/main/*.txt");
        for (Resource resource : fileResources) {
            System.out.println("文件路径 = " + resource.getFilename());
        }
    }
}
