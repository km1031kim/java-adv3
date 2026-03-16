package stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DownStreamMain2 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Pim", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

      // 1단계 : 학년별로 학생 그룹화
        Map<Integer, List<Student>> collect1 = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        // 2단계 : 학년별로 가장 점수가 높은 학생 구하기, reducing 사용
        Map<Integer, Optional<Student>> collect2 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.reducing((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2)
                ));

        System.out.println("collect2 = " + collect2);

        // 3단계 : 학년별로 가장 점수가 높은 학생을 구해라, maxBy 사용
        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.maxBy((Comparator.comparingInt(Student::getScore))
                        )));

        // 4단계 : 학년별로 가장 점수가 높은 학생의 이름을 구해라 (collectingAndThen + maxBy 사용)
        // 학년별 그룹 -> 그룹별 가장 점수가 높은 학생 -> 그룹별 최고점 학생 -> 그룹별 최고점 학생의 이름
        Map<Integer, String> collect4 = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student::getScore)),
                                sOpt -> sOpt.get().getName())));
        System.out.println("collect4 = " + collect4);
    }
}
