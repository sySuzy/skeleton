public class ArrayDeque<Item> {
    private Item[] array = (Item[]) new Object[8];
    private int array_size = 8;
    private int size = 0;
    private int start = 0;

    //    constructors
    public ArrayDeque() {
        return;
    }

    public ArrayDeque(Item[] x) {
        array = x;
        size = array_size = x.length;
    }

    // private tools
    private void resize() {
        double useage = (double)size / (double)array_size;
        System.out.println(useage);
        System.out.println(useage);
        if((useage<1.0 && useage>=0.25) || (useage<0.25 && array_size<=16)) {
            return;
        }
        Item[] array1;
        if(useage == 1.0) {
             array1 = (Item[]) new Object[array_size * 2];
        } else {
             array1 = (Item[]) new Object[array_size / 2];
        }

        int end = start + size;

        if(end>array_size) {
            end = end % array_size;
            System.arraycopy(array, start, array1, 0, array_size - start);
            System.arraycopy(array, 0, array1, array_size - start + 1, end);

        } else {
            System.arraycopy(array, start, array1, 0, size);
        }
        start = 0;
        array_size = array1.length;
        array = array1;
    }


    public boolean equals(Object A1) {
        if (!(A1 instanceof ArrayDeque)) {
            return false;
        }
        ArrayDeque A = (ArrayDeque) A1;
        if(A.size != this.size) {
            return false;
        }
        int i1 = this.start;
        int i2 = A.start;

        for(int i=0; i<size; i++) {
            if(array[i1] != A.array[i2]) {
                return false;
            }
            i1 = (i1 + 1) % array_size;
            i2 = (i2 + 1) % A.array_size;
        }
        return true;
    }

    public void addFirst(Item item) {
        if(size == array_size) {
            resize();
        }

        start = (start == 0) ? array_size-1 : start - 1;
        array[start] = item;
        size  = size + 1;
    }

    public void addLast(Item item) {
        if(size == array_size) {
            resize();
        }

        int end = (start + size - 1) % array_size;
        end = (end == array_size - 1) ? 0 : end + 1;
        array[end] = item;
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        int p = start;
        for(int i=0; i<size; i++) {
            System.out.print(array[p]);
            System.out.print('\t');
            p = p+1;
        }
        System.out.println('\t');
    }

    public Item removeFirst() {
        if(isEmpty()) {
            System.out.println("This Deque is Empty!");
            return null;
        }
        resize();
        Item pop = array[start];
        start = start + 1;
        size = size - 1;
        return pop;
    }

    public Item removeLast() {
        if(isEmpty()) {
            System.out.println("This Deque is Empty!");
            return null;
        }
        resize();
        int end = (start + size - 1) % array_size;
        Item pop = array[end];
        size = size-1;
        return pop;
    }

    public int size() {
        return size;
    }

    public Item get(int index) {
        if(index>size-1) {
            return null;
        }
        int i = (start + index) % array_size;
        return array[i];
    }




}