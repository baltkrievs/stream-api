package by.darashchonak.mentoring.stream;

import by.darashchonak.mentoring.stream.fi.TriFunction;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> addThemAll = (x, y, z) -> x + y + z;
        TriFunction<Double, Double, Double, Double> multiplyThemAll = (x, y, z) -> x * y * z;
        TriFunction<String, String, String, Integer> countThemAll = (x, y, z) -> x.length() + y.length() + z.length();


        System.out.println(addThemAll.apply(3,4,78));
        System.out.println(multiplyThemAll.apply(3.0 ,4.6,7.8));
        System.out.println(countThemAll.apply("Hello", "damn", "world"));




    }
}
