package com.demo.springdemo.java8;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoolStreamTest {

    public static double calc(List<Integer> ints) {

        // 临时中间集合
        List<Point2D> point2DList = new ArrayList<>();
        for (Integer i: ints) {
            point2DList.add(new Point2D.Double((double) i % 3, (double) i /3));
        }

        // 临时变量，为了获取最后结果的中间变量
        double total = 0;
        int count = 0;

        for (Point2D point2D: point2DList) {
            // 过滤
            if(point2D.getY() > 1) {
                // 算距离
                double distance = point2D.distance(0,0);
                total += distance;
                count++;
            }
        }
        // count 可能为 0
        return count > 0 ? total / count: 0;
    }

    @Test
    public void stream() {
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8);
        double average = calc(ints);

        Double streamResult = ints.stream()
                .map(i -> new Point2D.Double( (double) i % 3, (double)i / 3))
                .filter(point -> point.getY() > 1)
                .mapToDouble(point -> point.distance(0,0))
                .average()
                .orElse(0);

        assertThat(average, is(streamResult));
    }
}
