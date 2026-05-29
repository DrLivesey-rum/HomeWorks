package javacollectiontask1;

public class ArrayUtils {
    public static <T> T[] arrayMapping(T[] array, Function<T> mapper) {
        if (array == null || mapper == null) {
            throw new IllegalArgumentException();
        }
        T[] result = array.clone();
        for (int i = 0; i < result.length; i++) {
            result[i] = mapper.apply(array[i]);
        }
        return result;
    }
}
