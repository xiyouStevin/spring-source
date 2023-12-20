package com.xiyou.spring;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.util.Arrays;

/**
 * @author: Steven
 * @create: 2023-12-20 17:19
 * @Description:
 */

public class MetadataReaderDemo {
    public static void main(String[] args) throws Exception {
        //创建MetadataReaderFactory
        SimpleMetadataReaderFactory readerFactory = new SimpleMetadataReaderFactory();
        //获取MetadataReader,通常由Spring容器自动创建
        MetadataReader metadataReader = readerFactory.getMetadataReader("com.xiyou.spring.bean.MyBean");

        //获取类的基本信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println("获取类名：" + classMetadata.getClassName());
        System.out.println("是不是一个接口：" + classMetadata.isInterface());
        System.out.println("是不是一个注解：" + classMetadata.isAnnotation());
        System.out.println("是否是一个具体的类，既不是接口或抽象类，换句话说可new：" + classMetadata.isAnnotation());
        System.out.println("是否被Final修饰：" + classMetadata.isFinal());
        System.out.println("是否为“独立”的类，即顶层类,或者嵌套类：" + classMetadata.isIndependent());
        System.out.println("是否为内部类，嵌套类，局部类：" + classMetadata.hasEnclosingClass());
        System.out.println("获取外层类的名称，即上一层类的类名：" + classMetadata.getEnclosingClassName());
        System.out.println("是否有父类：" + classMetadata.hasSuperClass());
        System.out.println("获取父类名：" + classMetadata.getSuperClassName());
        System.out.println("获取实现的接口名：" + Arrays.toString(classMetadata.getInterfaceNames()));
        System.out.println("返回该类的内部类：" + Arrays.toString(classMetadata.getMemberClassNames()));
        System.out.println("返回注解类型：" + metadataReader.getAnnotationMetadata().getAnnotationTypes());

        System.out.println("--------------------------------");

        //获取方法上的注解
        for (MethodMetadata methodMetadata : metadataReader.getAnnotationMetadata().getAnnotatedMethods("com.xiyou.spring.annotation.MyAnnotation")){

            System.out.println("方法名：" + methodMetadata.getMethodName());
            System.out.println("申明方法所在的类名：" + methodMetadata.getDeclaringClassName());
            System.out.println("获取方法返回值类型名：" + methodMetadata.getReturnTypeName());
            System.out.println("是不是抽象方法：" + methodMetadata.isAbstract());
            System.out.println("是不是静态方法：" + methodMetadata.isStatic());
            System.out.println("是不是final方法：" + methodMetadata.isFinal());
            System.out.println("方法是否可以被重写：" + methodMetadata.isOverridable());
            System.out.println("");
        }
    }
}
