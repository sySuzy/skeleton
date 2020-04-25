import java.security.KeyStore;

public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode (int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }

    public IntNode first;

    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    public void insert(int item, int position) {
        if ((first == null) || (position == 0)){
            addFirst(item);
        } else {
            IntNode p= first;
            int pos = position;
            while ((p.next != null) && (pos != 1)){
                p = p.next;
                pos = pos - 1;
            }
            p.next = new IntNode(item, p.next);
        }
    }

//     recursive
    private IntNode[] reverse_helper(IntNode p) {
        if(p.next == null) return new IntNode[]{p, p};
        IntNode[] res = reverse_helper(p.next);
        res[1].next = p;
        p.next = null;
        IntNode[] return_res = new IntNode[]{res[0], p};
        return return_res;
    }
    public void reverse() {
        if (this.first == null) return;
        IntNode[] res = reverse_helper(this.first);
        this.first = res[0];
    }

    public boolean equals(SLList new_list) {
        IntNode p1 = this.first;
        IntNode p2 = new_list.first;
        while (p1 != null && p2 != null) {
            if (p1.item != p2.item) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == null && p2 == null) {
            return true;
        } else {
            return false;
        }
    }

    public void print(){
        IntNode p = this.first;
        while(p != null){
            System.out.println(p.item);
            p = p.next;
        }
    }
}

