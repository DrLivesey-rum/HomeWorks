package javacollectiontask2;

import java.util.HashMap;
import java.util.Map;

public class CollectionUtils {

    public static <T> Map<T, Integer> countElements(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        Map<T, Integer> result = new HashMap<>();
        for (T element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }
}
