import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void Test() {
        StudentArrayDeque<Integer> deque1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expect = new ArrayDequeSolution<>();
        String msg = new String();

        Integer v1 = Integer.valueOf(StdRandom.uniform(100));
        deque1.addLast(v1);
        expect.addLast(v1);
        msg = msg + "addLast(" + v1 + ")\n";

        Integer v2 = Integer.valueOf(StdRandom.uniform(100));
        deque1.addFirst(v2);
        expect.addFirst(v2);
        msg = msg + "addFirst(" + v2 + ")\n";

        Integer v3 = Integer.valueOf(StdRandom.uniform(100));
        deque1.addLast(v3);
        expect.addLast(v3);
        msg = msg + "addLast(" + v3 + ")\n";

        Integer v4 = Integer.valueOf(StdRandom.uniform(100));
        deque1.addFirst(v4);
        expect.addFirst(v4);
        msg = msg + "addFirst(" + v4 + ")\n";

        Integer v5 = Integer.valueOf(StdRandom.uniform(100));
        deque1.addLast(v5);
        expect.addLast(v5);
        msg = msg + "addLast(" + v5 + ")\n";

        Integer v6 = Integer.valueOf(StdRandom.uniform(100));
        deque1.addLast(v6);
        expect.addLast(v6);
        msg = msg + "addLast(" + v6 + ")\n";

        Integer v7 = Integer.valueOf(StdRandom.uniform(100));
        deque1.addFirst(v7);
        expect.addFirst(v7);
        msg = msg + "addFirst(" + v7 + ")\n";

        Integer d1 = deque1.removeLast();
        Integer d2 = expect.removeLast();
        msg = msg + "removeLast()\n";
        assertEquals(msg, d2, d1);


        Integer v8 = Integer.valueOf(StdRandom.uniform(100));
        deque1.addFirst(v8);
        expect.addFirst(v8);
        msg = msg + "addFirst(" + v8 + ")\n";

        Integer d = deque1.removeLast();
        Integer e = expect.removeLast();
        msg = msg + "removeLast()\n";
        assertEquals(msg, e, d);


//        for(int i=0; i<10;i++) {
//            double r1 = StdRandom.uniform();
//            if(r1 < 0.5) {
//                Integer v1 = Integer.valueOf(StdRandom.uniform(100));
//                deque1.addFirst(v1);
//                expect.addFirst(v1);
//                msg = msg + "addFirst(" + v1 + ")\n";
//            }
//
//            double r2 = StdRandom.uniform();
//            if(r2 < 0.5) {
//                Integer v2 = Integer.valueOf(StdRandom.uniform(100));
//                deque1.addLast(v2);
//                expect.addLast(v2);
//                msg = msg + "addLast(" + v2 + ")\n";
//            }

//            double r3 = StdRandom.uniform();
//            if(deque1.size()>0 && r3 < 0.2) {
//                 Integer f1 = deque1.removeFirst();
//                 Integer f2 = expect.removeFirst();
//                 msg = msg + "removeFirst()\n";
//                 assertEquals(msg, f1, f2);
//
//            }
//
//            double r4 = StdRandom.uniform();
//            if(deque1.size()>0 && r4 < 0.2) {
//                Integer l1 = deque1.removeLast();
//                Integer l2 = expect.removeLast();
//                msg = msg + "removeLast()\n";
//                assertEquals(msg, l1, l2);
//            }
//
//
//
//
//
//        }
//
    }
}
