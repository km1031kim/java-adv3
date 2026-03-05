package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

import static lambda.lambda5.filter.GenericFilter.*;
import static lambda.lambda5.map.GenericMapper.*;

public class Ex1_Lambda {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // GenericFilter, GenericMapper
        List<Integer> mapped = map(filter(numbers, (n1) -> n1 % 2 == 0), (n) -> (n * 2));
        System.out.println("mapped = " + mapped);
        Integer.valueOf(2);

        int a = 2;
        Integer integer = Integer.valueOf(a);

        IntFunction<Integer[]> intValue = n -> {
            List<Integer> list = new ArrayList<>();
            list.add(n);
            return list.toArray(new Integer[0]);
        };


        numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 2).toArray(intValue);
    }
}
