package javastreamapitask2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamCollectMap {

    // 1. Создаём коллекцию студентов
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        // 2. Обрабатываем через parallelStream
        Map<String, Double> averageBySubject = students.parallelStream()
                .flatMap(student -> student.getGrades().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)
                ));

        // 3. Выводим результат
        System.out.println("Средние оценки по предметам:");
        averageBySubject.forEach((subject, avg) ->
                System.out.printf("%s: %.2f%n", subject, avg));
    }
}

