package javacollectiontask1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        // Пример 1:
        Integer[] numbers = {1, 2, 3, 4, 5};
        Function<Integer> multiplyByTwo = i -> i * 2;
        Integer[] doubled = ArrayUtils.arrayMapping(numbers, multiplyByTwo);
        System.out.println("Умножение на 2: " + Arrays.toString(doubled));


        // Пример 2:
        Person[] people = {
                new Person("Alice", 30),
                new Person("Bob", 25)
        };

        Function<Person> incrementAge = p -> new Person(p.name(), p.age() + 1);
        Person[] agedPeople = ArrayUtils.arrayMapping(people, incrementAge);
        System.out.println("После увеличения возраста: " + Arrays.toString(agedPeople));
    }
}
