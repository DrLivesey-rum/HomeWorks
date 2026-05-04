package javacoretask1;

import java.util.Stack;

public class UndoableStringBuilder {
    private char[] value;
    private int count;
    private final Stack<BuilderSnapshot> history = new Stack<>();

    public UndoableStringBuilder() {
        value = new char[16];
        count = 0;
    }

    public UndoableStringBuilder(String str) {
        value = new char[str.length() + 16];
        append(str); // не сохраняем начальное состояние в историю
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > value.length) {
            int newCapacity = (value.length * 2) + 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, count);
            value = newValue;
        }
    }

    private void saveState() {
        history.push(new BuilderSnapshot(value, count));
    }

    public UndoableStringBuilder append(String str) {
        saveState();
        if (str == null) str = "null";
        int len = str.length();
        ensureCapacity(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }

    public UndoableStringBuilder append(char c) {
        saveState();
        ensureCapacity(count + 1);
        value[count++] = c;
        return this;
    }

    public UndoableStringBuilder delete(int start, int end) {
        saveState();
        if (start < 0) throw new StringIndexOutOfBoundsException(start);
        if (end > count) end = count;
        if (start > end) throw new StringIndexOutOfBoundsException();
        int len = end - start;
        if (len > 0) {
            System.arraycopy(value, start + len, value, start, count - end);
            count -= len;
        }
        return this;
    }

    public boolean undo() {
        if (history.isEmpty()) {
            return false;
        }
        BuilderSnapshot snapshot = history.pop();
        this.value = snapshot.valueCopy();
        this.count = snapshot.count();
        return true;
    }

    public int length() {
        return count;
    }

    public int getHistorySize() {
        return history.size();
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}