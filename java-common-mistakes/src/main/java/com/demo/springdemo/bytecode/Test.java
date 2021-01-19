package com.demo.springdemo.bytecode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws  Exception{
        Path path = Paths.get(Test.class.getResource("input.txt").toURI());

        StringBuilder data = new StringBuilder();
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(data::append);
        }

        System.out.println(data.toString());
    }
}


