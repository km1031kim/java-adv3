package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartMain2 {

    private static final Map<Long, String> map = new HashMap<>();

    // 스태틱 블록은 어플리케이션 호출 시 먼저 호출됨.
    static {
        map.put(1L, "Kim");
        map.put(2L, "Seo");
    }

    public static void main(String[] args) {
        findAndPrint(1L); // 값이 있는 경우
        findAndPrint(3L); // 값이 없는 경우
    }

    // 이름이 있으면 이름을 대문자로 출력, 없으면 "UNKNOWN"을 출력하라
    static void findAndPrint(Long id) {
        System.out.println(findNameById(id).orElse("UNKNOWN"));
    }

    static Optional<String> findNameById(Long id) {
        String findName = map.get(id);
        return Optional.ofNullable(findName);
    }
}
