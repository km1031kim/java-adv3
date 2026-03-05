package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex2_Student {

    public static void main(String[] args) {
        List<Student> students = List.of(new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40));


        List<String> directResult = direct(students);
        List<String> lambdaResult = lambda(students);

        System.out.println("lambdaResult = " + lambdaResult);
        System.out.println("directResult = " + directResult);

    }

    private static List<String> direct(List<Student> students) {
        List<String> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() >= 80) {
                result.add(student.getName());
            }
        }
        return result;
    }

    private static List<String> lambda(List<Student> students) {
        return GenericMapper.map(GenericFilter.filter(students, student -> student.getScore() >= 80), Student::getName);
        }
}
