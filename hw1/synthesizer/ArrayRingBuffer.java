package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        this.fillCount = 0;
        this.first = 0;
        this.last = 0;
        this.rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (this.isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        } else {
            rb[last] = x;
            last = (last + 1) % capacity;
            fillCount += 1;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        } else {
            T res = rb[first];
            first = (first + 1) % capacity;
            fillCount -= 1;
            return res;
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("The deque is empty!");
        } else {
            return rb[first];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new OurIterator();
    }

    private class OurIterator implements Iterator<T> {
        int index;

        OurIterator() {
            index = first;
        }

        public boolean hasNext() {
            return index != last;
        }

        public T next() {
            T res = rb[index];
            index = (index + 1) % capacity;
            return res;
        }

    }

//    public static void main(String[] args) {
//        BoundedQueue<Double> x = new ArrayRingBuffer<>(4);
//        x.enqueue(33.1); // 33.1 null null  null
//        x.enqueue(44.8); // 33.1 44.8 null  null
//        x.enqueue(62.3); // 33.1 44.8 62.3  null
//        x.enqueue(-3.4); // 33.1 44.8 62.3 -3.4
//        System.out.println(x.dequeue());     // 44.8 62.3 -3.4  null (returns 33.1)
//        System.out.println(x.dequeue());
//    }

}
