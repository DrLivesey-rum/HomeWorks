package javaconcurrencytask1;

public class BlockingQueue<T> {
    private final T[] elements;
    private final int capacity;
    private int count;          // текущее количество элементов
    private int head;           // индекс, откуда извлекать
    private int tail;           // индекс, куда добавлять

    public BlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }

    /**
     * Добавляет элемент в очередь.
     * Если очередь полна, поток блокируется до появления места.
     */
    public synchronized void enqueue(T item) throws InterruptedException {
        while (count == capacity) {
            wait();
        }
        elements[tail] = item;
        tail = (tail + 1) % capacity;
        count++;
        notifyAll();
    }

    /**
     * Извлекает и возвращает элемент из очереди.
     * Если очередь пуста, поток блокируется до появления элемента.
     */
    public synchronized T dequeue() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        T item = elements[head];
        elements[head] = null;
        head = (head + 1) % capacity;
        count--;
        notifyAll();
        return item;
    }

    /**
     * Возвращает текущее количество элементов в очереди.
     */
    public synchronized int size() {
        return count;
    }
}
