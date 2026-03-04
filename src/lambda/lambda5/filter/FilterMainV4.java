package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMainV4 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IntegerFilter.filter(numbers, n1 -> n1 % 2 == 0);
        IntegerFilter.filter(numbers, n1 -> n1 % 2 == 1);
    }
}
