package com.demo.springdemo.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;


public class EncodedResourceExample {

    public static void main(String[] args) throws Throwable {
        Resource res = new ClassPathResource("conf/file1.txt");
        EncodedResource encRes = new EncodedResource(res, "utf-8");
        String content = FileCopyUtils.copyToString(encRes.getReader());
        System.out.println(content);
    }
}
