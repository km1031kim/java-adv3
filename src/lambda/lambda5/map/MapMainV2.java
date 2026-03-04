package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV2 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3", "4123");

        // 문자 -> 숫자
        Function<String, Integer> function = Integer::valueOf;
        List<Integer> numbers = map(list, function);

        // 문자열의 길이
        List<Integer> lengths = map(list, String::length);

        System.out.println("numbers = " + numbers);
        System.out.println("lengths = " + lengths);
        
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> results = new ArrayList<>();
        for (T t : list) {
            results.add(mapper.apply(t));
        }
        return results;
    }
}
