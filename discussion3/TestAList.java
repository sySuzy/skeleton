import org.junit.Test;
import static org.junit.Assert.*;

public class TestAList {

    @Test
    public void TestInsert(){
        int[] old = new int[]{1,2,3,4,5,6};
        int[] x1 = AList.insert(old, 0, 0);
        int[] x2 = AList.insert(old, 0, 1);
        int[] x3 = AList.insert(old, 0, 10);
        int[] expect1 = new int[]{0,1,2,3,4,5,6};
        int[] expect2 = new int[]{1,0,2,3,4,5,6};
        int[] expect3 = new int[]{1,2,3,4,5,6,0};
        assertArrayEquals(expect1, x1);
        assertArrayEquals(expect2, x2);
        assertArrayEquals(expect3, x3);
    }

    @Test
    public void TestReverse(){
        int[] x1 = new int[]{1};
        AList.reverse(x1);
        int[] x2 = new int[]{1,2};
        AList.reverse(x2);
        int[] x3 = new int[]{2,4,3,6,5,8};
        AList.reverse(x3);
        int[] x4 = new int[]{2,3,4,7,4};
        AList.reverse(x4);

        int[] expect1 = new int[]{1};
        int[] expect2 = new int[]{2,1};
        int[] expect3 = new int[]{8,5,6,3,4,2};
        int[] expect4 = new int[]{4,7,4,3,2};
        assertArrayEquals(expect1, x1);
        assertArrayEquals(expect2, x2);
        assertArrayEquals(expect3, x3);
        assertArrayEquals(expect4, x4);
    }

    @Test
    public void TestXify(){
        int[] x1 = new int[]{3,2,1};
        int[] actual1 = AList.xify(x1);

        int[] x2 = new int[]{0};
        int[] actual2 = AList.xify(x2);

        int[] x3 = new int[]{0,3};
        int[] actual3 = AList.xify(x3);

        int[] expect1 = new int[]{3,3,3,2,2,1};
        int[] expect2 = new int[0];
        int[] expect3 = new int[]{3,3,3};
        assertArrayEquals(expect1, actual1);
        assertArrayEquals(expect2, actual2);
        assertArrayEquals(expect3, actual3);


    }
}