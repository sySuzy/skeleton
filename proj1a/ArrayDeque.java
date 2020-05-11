
public class ArrayDeque<T> {
    private T[] array = (T[]) new Object[8];
    private int arraySize = 8;
    private int size = 0;
    private int start = 0;

    //    constructors
    public ArrayDeque() {
    }


    // private tools
    private void resize() {
        double useage = (double) size / (double) arraySize;
        if ((useage < 1.0 && useage >= 0.25) || (useage < 0.25 && arraySize <= 16)) {
            return;
        }
        T[] array1;
        if (useage == 1.0) {
            array1 = (T[]) new Object[arraySize * 2];
        } else {
            array1 = (T[]) new Object[arraySize / 2];
        }

        int end = start + size;

        if (end > arraySize) {
            end = end % arraySize;
            System.arraycopy(array, start, array1, 0, arraySize - start);
            System.arraycopy(array, 0, array1, arraySize - start, end);

        } else {
            System.arraycopy(array, start, array1, 0, size);
        }
        start = 0;
        arraySize = array1.length;
        array = array1;
    }


//    public boolean equals(Object A1) {
//        if (!(A1 instanceof ArrayDeque)) {
//            return false;
//        }
//        ArrayDeque A = (ArrayDeque) A1;
//        if (A.size != this.size) {
//            return false;
//        }
//        int i1 = this.start;
//        int i2 = A.start;
//
//        for (int i = 0; i < size; i++) {
//            if (array[i1] != A.array[i2]) {
//                return false;
//            }
//            i1 = (i1 + 1) % arraySize;
//            i2 = (i2 + 1) % A.arraySize;
//        }
//        return true;
//    }

    public void addFirst(T item) {
        if (size == arraySize) {
            resize();
        }

        start = (start == 0) ? arraySize - 1 : start - 1;
        array[start] = item;
        size  = size + 1;
    }

    public void addLast(T item) {
        if (size == arraySize) {
            resize();
        }

        int end = (start + size - 1) % arraySize;
        end = (end == arraySize - 1) ? 0 : end + 1;
        array[end] = item;
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        int p = start;
        for (int i = 0; i < size; i++) {
            System.out.print(array[p]);
            System.out.print('\t');
            p = p + 1;
        }
        System.out.println('\t');
    }

    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("This Deque is Empty!");
            return null;
        }
        resize();
        T pop = array[start];
        start = (start + 1) % arraySize;
        size = size - 1;
        return pop;
    }

    public T removeLast() {
        if (isEmpty()) {
            System.out.println("This Deque is Empty!");
            return null;
        }
        resize();
        int end = (start + size - 1) % arraySize;
        T pop = array[end];
        size = size - 1;
        return pop;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        int i = (start + index) % arraySize;
        return array[i];
    }


}

