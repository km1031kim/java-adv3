package functional;

import java.util.function.Function;

public class CompositionMain2 {
    public static void main(String[] args) {
        //1. String -> Integer
        Function<String, Integer> parseInt = Integer::parseInt;

        // 2. Integer -> Integer ( 여기서는 제곱 )
        Function<Integer, Integer> square = x -> x * x;

        // 3. Integer -> String
        Function<Integer, String> toString = x -> "결과: " + x;

        Function<String, String> finalFunc = parseInt.andThen(square).andThen(toString);
        System.out.println("finalFunc.apply(\"3\") = " + finalFunc.apply("3"));


    }
}
