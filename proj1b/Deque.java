public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    T removeFirst();
    T removeLast();
    int size();
    T get(int index);
    void printDeque();
}
