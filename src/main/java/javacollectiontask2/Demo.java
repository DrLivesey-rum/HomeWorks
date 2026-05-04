package javacollectiontask2;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {

        // Пример 1: массив строк
        String[] fruits = {"apple", "banana", "apple", "orange", "banana", "apple"};
        Map<String, Integer> fruitCount = CollectionUtils.countElements(fruits);
        System.out.println("Фрукты: " + fruitCount);

        // Пример 2:
        Person[] people = {
                new Person("Алина", 30),
                new Person("Борис", 25),
                new Person("Алина", 30),
                new Person("Никита", 35)
        };
        Map<Person, Integer> personCount = CollectionUtils.countElements(people);
        System.out.println("Люди: " + personCount);
    }
}
