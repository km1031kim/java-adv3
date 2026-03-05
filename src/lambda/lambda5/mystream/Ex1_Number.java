package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;

public class Ex1_Number {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수만 남기기,
        // 남은 짝수 값의 2배를 반환하기
        // Predicate filter, mapper

        List<Integer> result = apply(numbers);
        System.out.println("result = " + result);
    }

    private static List<Integer> apply(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
       for (Integer number : numbers) {
            if (number % 2 == 0) {
                result.add(number * 2);
            }
        }
        return result;
    }
}
