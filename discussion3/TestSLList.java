import org.junit.Test;
import static org.junit.Assert.*;

public class TestSLList {
    @Test
    public void testInsert(){
        SLList p = new SLList();
        p.addFirst(5);
        p.addFirst(6);
        p.addFirst(7);
        p.insert(0, 2);
        SLList expect = new SLList();

        expect.addFirst(5);
        expect.addFirst(0);
        expect.addFirst(6);
        expect.addFirst(7);

        System.out.println(expect.equals(p));
    }

    @Test
    public void testReverse(){
        SLList p = new SLList();
        p.addFirst(4);
        p.addFirst(5);
        p.addFirst(6);
        p.reverse();

        SLList q = new SLList();
        q.addFirst(6);
        q.addFirst(5);
        q.addFirst(4);
        System.out.println(q.equals(p));
    }
}