package functional;

import java.util.function.Function;

public class CompositionMain1 {
    public static void main(String[] args) {
        // 1. x -> x * x
        Function<Integer, Integer> square = x -> x * x;

        // 2. x -> x + 1
        Function<Integer, Integer> add = x -> x + 1;

        // 함수 합성
        // 1. compose()를 사용한 새로운 함수 생성
        // 먼저 add 적용 후 square 적용하는 새로운 함수 newFunc1 생성
        // square(add(2))
        Function<Integer, Integer> newFunc1 = square.compose(add);
        Integer apply = newFunc1.apply(2);
        System.out.println("apply = " + apply);

        // 2, andThen()을 사용한 새로운 함수 생성
        Function<Integer, Integer> newFunc2 = square.andThen(add);
        Integer apply2 = newFunc2.apply(3);
        System.out.println("apply2 = " + apply2);

    }
}
