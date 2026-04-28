package javacoretask1;

public class Demo {
    public static void main(String[] args) {
        UndoableStringBuilder builder = new UndoableStringBuilder();

        builder.append("Hello");
        builder.append(", ");
        builder.append("World!");

        System.out.println("После добавлений: " + builder);
        System.out.println("Размер истории: " + builder.getHistorySize());

        builder.delete(5, 12);
        System.out.println("После delete(5,12): " + builder);
        System.out.println("Размер истории: " + builder.getHistorySize());

        while (builder.undo()) {
            System.out.println("undo -> " + builder);
        }

        System.out.println("Финальная строка: '" + builder + "'");
    }
}
