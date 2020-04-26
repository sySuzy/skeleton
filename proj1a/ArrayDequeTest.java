import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void testAddFirst() {
        ArrayDeque x1 = new ArrayDeque();
        for (int i : new int[]{2,3}) {
            x1.addFirst(i);
        }
        ArrayDeque expect1 = new ArrayDeque(new Integer[]{3,2});
        assertEquals(expect1, x1);

        ArrayDeque x2 = new ArrayDeque();
        for (int i : new int[]{1,2,3,4,5,6,7,8,9,10}) {
            x2.addFirst(i);
        }
        ArrayDeque expect2 = new ArrayDeque(new Integer[]{10,9,8,7,6,5,4,3,2,1});
        assertEquals(expect2, x2);
    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<Integer> x1 = new ArrayDeque<Integer>(new Integer[]{1,2,3,4,5,6,7});
        Integer pop = x1.removeFirst();
        assertEquals(pop, Integer.valueOf(1));
        assertEquals(new ArrayDeque<Integer>(new Integer[]{2,3,4,5,6,7}), x1);
    }

    @Test
    public void testRemoveLast() {
        ArrayDeque<Integer> x1 = new ArrayDeque<Integer>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11});
        Integer pop = Integer.valueOf(0);
        for(int i=0;i<10;i++) {
             pop = x1.removeLast();

        }

        assertEquals(pop, Integer.valueOf(2));
        assertEquals(new ArrayDeque<Integer>(new Integer[]{1}), x1);
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> x1 = new ArrayDeque<Integer>(new Integer[]{0,1,2,3,4,5,6});
        assertEquals(x1.get(0), Integer.valueOf(0));
        assertEquals(x1.get(5), Integer.valueOf(5));
        assertEquals(x1.get(100), null);
    }


}