public class LinkedListDeque<T> {
    private class ItemNode {
        public T value;
        public ItemNode after;
        public ItemNode before;
        public ItemNode(T value, ItemNode after, ItemNode before) {
            this.value = value;
            this.after = after;
            this.before = before;
        }
        public ItemNode(T value) {
            this.value = value;
            this.after = this;
            this.before = this;
        }
    }

    private ItemNode sentinel = new ItemNode(null);
    private int size = 0;

    public LinkedListDeque() {
        return;
    }

    public void addFirst(T item) {
        sentinel.after= new ItemNode(item, sentinel.after, sentinel);
        sentinel.after.after.before = sentinel.after;
        size ++;
    }

    public void addLast(T item) {
        sentinel.before = new ItemNode(item, sentinel, sentinel.before);
        sentinel.before.before.after = sentinel.before;
        size ++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ItemNode p = sentinel.after;
        for (int i=0; i<size; i++) {
            System.out.print(p.value);
            p = p.after;
        }
    }

    public T removeFirst() {
        if(size == 0) {
            System.out.println("The list is already empty!");
            return null;
        }
        T item = sentinel.after.value;
        sentinel.after = sentinel.after.after;
        sentinel.after.before = sentinel;
        size --;
        return item;
    }

    public T removeLast() {
        if(size == 0) {
            System.out.println("The list is already empty!");
            return null;
        }
        T item = sentinel.before.value;
        sentinel.before = sentinel.before.before;
        sentinel.before.after = sentinel;
        size --;
        return item;
    }

    public T get(int index) {
        ItemNode p = sentinel;
        if(index>size-1) {
            System.out.println("index out of range!");
            return null;
        }
        for(int i=0; i<index+1; i++) {
            p = p.after;
        }
        return p.value;
    }

    private T getRecursiveHelper(ItemNode p, int pos) {
        if(pos==0) {
            return p.value;
        } else {
            return getRecursiveHelper(p.after, pos-1);
        }
    }

    public T getRecursive(int index) {
        if(index>size-1){
            System.out.println("index out of range!");
            return null;
        } else {
            return getRecursiveHelper(sentinel.after, index);
        }
    }
}