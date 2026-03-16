package optional;

import java.util.Optional;

public class OptionalRetrievalMain {
    public static void main(String[] args) {
        //
        Optional<String> optValue = Optional.of("hello");
        Optional<String> optEmpty = Optional.empty();

        // isPresent() : 값이 있으면 true
        System.out.println("=== 1. isPresent() / isEmpty() ===");
        System.out.println("optValue.isPresent() = " + optValue.isPresent());
        System.out.println("optEmpty.isPresent() = " + optEmpty.isPresent());
        System.out.println("optEmpty.isEmpty() = " + optEmpty.isEmpty());

        // get() : 직접 내부 값을 꺼냄, 값이 없으면 에외 (NoSuchElementException)
        System.out.println("=== 2. get() ===");
        String getValue = optValue.get();
        System.out.println("getValue = " + getValue);
        // String getValue2 = optEmpty.get();

        // 값이 있으면 그 값, 없으면 지정된 기본값 사용
        System.out.println("=== 3. orElse() ===");
        String value1 = optValue.orElse("기본값");
        System.out.println("value1 = " + value1);
        String empty1 = optEmpty.orElse("기본값");
        System.out.println("empty1 = " + empty1);

        // 값이 없을 때만 람다(Supplier)가 실행되어 기본값 생성
        System.out.println("=== 4. orElseGet() ===");
        String value2 = optValue.orElseGet(() -> {
            System.out.println("람다 호출");
            return "New Value";
        });

        String empty2 = optEmpty.orElseGet(() -> "New Value");
        System.out.println("value2 = " + value2);
        System.out.println("empty2 = " + empty2);


        // 값이 있으면 반환, 없으면 예외 발생
        System.out.println("=== 5. orElseThrow() ===");
        String value3 = optValue.orElseThrow(() -> new RuntimeException("값이 없습니다."));


        try {
            String empty = optEmpty.orElseThrow(() -> new RuntimeException("값이 없습니다."));
            System.out.println("empty = " + empty);
        } catch (RuntimeException e) {
            System.out.println("예외 발생 : " + e.getMessage());
        }

        // Optional을 반환
        System.out.println("=== 6. or() ===");
        Optional<String> result = optValue.or(() -> Optional.of("FallBack"));// 값이 없으면 람다 실행 결과로 옵셔널 반환
        System.out.println("result = " + result);

        Optional<String> fallBAck = optEmpty.or(() -> Optional.of("FallBAck"));
        System.out.println("fallBAck = " + fallBAck);


    }
}
