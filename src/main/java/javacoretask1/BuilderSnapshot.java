package javacoretask1;

final class BuilderSnapshot {
    private final char[] valueCopy;
    private final int count;

    BuilderSnapshot(char[] value, int count) {
        this.valueCopy = new char[value.length];
        System.arraycopy(value, 0, this.valueCopy, 0, value.length);
        this.count = count;
    }

    char[] getValueCopy() {
        return valueCopy;
    }

    int getCount() {
        return count;
    }
}