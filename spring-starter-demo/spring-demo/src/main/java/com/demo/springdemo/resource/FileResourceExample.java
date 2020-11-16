package com.demo.springdemo.resource;

import org.springframework.core.io.*;

import java.io.*;

public class FileResourceExample {

    public static void main(String[] args) {
        try {
            String filePath = "/Users/peterliu/github/coding-demo/spring-starter-demo/spring-demo/src/main/resources/conf/file1.txt";

            // 使用系统文件路径方式加载文件
            WritableResource res1 = new FileSystemResource(filePath);

            // 以类路径方式加载文件
            Resource res2 = new ClassPathResource("conf/file1.txt");

            // 使用 WritableResource 接口写文件
            OutputStream stream1 = res1.getOutputStream();
            stream1.write("Welcome file txt1".getBytes());
            stream1.close();

            // 使用 Resource 接口读取资源文件
            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while((i=ins1.read()) != -1) {
                baos.write(i);
            }
            System.out.println(baos.toString());

            System.out.println("res1: "+res1.getFilename());
            System.out.println("res2: "+res2.getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
