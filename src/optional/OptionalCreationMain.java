package optional;

import java.nio.file.OpenOption;
import java.util.Optional;

public class OptionalCreationMain {
    public static void main(String[] args) {
        // 1. of() : 값이 null이 아님이 확실할 때 사용, null 이면 NullPointerException 발생
        String nonNullValue = "Hello Optional!";
        Optional<String> opt1 = Optional.of(nonNullValue);
        System.out.println("opt1 = " + opt1);

        // 2. ofNullable() : 값이 null일 수도 있고 아닐 수도 있을 떄
        Optional<String> opt2 = Optional.ofNullable("Hello!");
        Optional<Object> opt3 = Optional.ofNullable(null);
        System.out.println("opt2 = " + opt2);
        System.out.println("opt3 = " + opt3); // empty 인스턴스 하나로 표현

        // 3. empty() 비어있는 Optional 을 명시적으로 생성
        Optional<Object> empty = Optional.empty(); // 스태틱 인스턴스
        System.out.println("empty = " + empty);



    }
}
