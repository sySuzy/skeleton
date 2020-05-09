public class LinkedListDeque<Item> implements Deque<Item> {
    private class ItemNode {
        public Item value;
        public ItemNode after;
        public ItemNode before;
        public ItemNode(Item value, ItemNode after, ItemNode before) {
            this.value = value;
            this.after = after;
            this.before = before;
        }
        public ItemNode(Item value) {
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

    @Override
    public void addFirst(Item item) {
        sentinel.after= new ItemNode(item, sentinel.after, sentinel);
        sentinel.after.after.before = sentinel.after;
        size ++;
    }
    @Override
    public void addLast(Item item) {
        sentinel.before = new ItemNode(item, sentinel, sentinel.before);
        sentinel.before.before.after = sentinel.before;
        size ++;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        ItemNode p = sentinel.after;
        for (int i=0; i<size; i++) {
            System.out.print(p.value);
            p = p.after;
        }
    }
    @Override
    public Item removeFirst() {
        if(size == 0) {
            System.out.println("The list is already empty!");
            return null;
        }
        Item item = sentinel.after.value;
        sentinel.after = sentinel.after.after;
        sentinel.after.before = sentinel;
        size --;
        return item;
    }
    @Override
    public Item removeLast() {
        if(size == 0) {
            System.out.println("The list is already empty!");
            return null;
        }
        Item item = sentinel.before.value;
        sentinel.before = sentinel.before.before;
        sentinel.before.after = sentinel;
        size --;
        return item;
    }
    @Override
    public Item get(int index) {
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

    private Item getRecursiveHelper(ItemNode p, int pos) {
        if(pos==0) {
            return p.value;
        } else {
            return getRecursiveHelper(p.after, pos-1);
        }
    }

    public Item getRecursive(int index) {
        if(index>size-1){
            System.out.println("index out of range!");
            return null;
        } else {
            return getRecursiveHelper(sentinel.after, index);
        }
    }
}