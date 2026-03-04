package lambda.lambda5.map;

import java.util.List;

public class MapMainV5 {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "orange");

        // String -> String
        List<String> upperFruits = GenericMapper.map(fruits, String::toUpperCase);
        System.out.println("upperFruits = " + upperFruits);

        List<Integer> lengthFruits = GenericMapper.map(fruits, String::length);
        System.out.println("lengthFruits = " + lengthFruits);

        // Integer -> String
        List<Integer> integers = List.of(1, 2, 3);
        List<String> startList = GenericMapper.map(integers, "*"::repeat);
        System.out.println("startList = " + startList);
    }
}
