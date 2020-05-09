import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    @Test
    public void Test() {
        StudentArrayDeque<Integer> deque1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expect = new ArrayDequeSolution<>();
        String msg = new String();
        for(int i=0; i<100;i++) {
            double r1 = StdRandom.uniform();
            if(r1 < 0.5) {
                Integer v1 = Integer.valueOf(StdRandom.uniform(100));
                deque1.addFirst(v1);
                expect.addFirst(v1);
                msg = msg + "addFirst(" + v1 + ")\n";
            }

            double r2 = StdRandom.uniform();
            if(r2 < 0.5) {
                Integer v2 = Integer.valueOf(StdRandom.uniform(100));
                deque1.addLast(v2);
                expect.addLast(v2);
                msg = msg + "addLast(" + v2 + ")\n";
            }

            double r3 = StdRandom.uniform();
            if(deque1.size()>0 && r3 < 0.2) {
                 Integer f1 = deque1.removeFirst();
                 Integer f2 = expect.removeFirst();
                 msg = msg + "removeFirst()\n";
                 assertEquals(msg, f1, f2);

            }

            double r4 = StdRandom.uniform();
            if(deque1.size()>0 && r4 < 0.2) {
                Integer l1 = deque1.removeLast();
                Integer l2 = expect.removeLast();
                msg = msg + "removeLast()\n";
                assertEquals(msg, l1, l2);
            }



        }

    }
}
