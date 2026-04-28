package javacoretask1;

record BuilderSnapshot(char[] valueCopy, int count) {
    BuilderSnapshot(char[] valueCopy, int count) {
        this.valueCopy = new char[valueCopy.length];
        System.arraycopy(valueCopy, 0, this.valueCopy, 0, valueCopy.length);
        this.count = count;
    }
}