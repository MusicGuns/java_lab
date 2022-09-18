import static org.junit.Assert.*;
import org.junit.Test;

public class TestVector {
    @Test
    public void test1() throws Exception {
        MyVector<Object> vector = new MyVector<Object>();
        assertEquals(0, vector.size());
        assertEquals(10, vector.capacity());
    }

    @Test
    public void test2() throws Exception {
        MyVector <Integer> vector = new MyVector<Integer>(new Integer[] {1,7,5,4});
        assertEquals(4, vector.size());
        assertEquals(18, vector.capacity());

        MyVector <Integer> vector1 = new MyVector<Integer>(vector);
        assertEquals(4, vector1.size());
        assertEquals(18, vector1.capacity());
    }

    @Test
    public void test3() throws Exception {
        MyVector <Integer> vector = new MyVector<Integer>(new Integer[] {1,7,5,4});
        vector.addElementToEnd(9);
        assertEquals(5, vector.size());
        assertEquals(18, vector.capacity());
        assertEquals(9, vector.returnAtIndex(4));
        for (int i = 0; i < 14; i++ ) {
            vector.addElementToEnd(i);   
        }
        assertEquals(19, vector.size());
        assertEquals(46, vector.capacity());

        vector.addElementToIndex(100, 17);
        assertEquals(100, vector.returnAtIndex(17));
        assertThrows(Exception.class, () -> {
            vector.addElementToIndex(100, 20);
        });

        vector.changeSizeToArray(5);
        assertEquals(5, vector.size());
        assertEquals(5, vector.capacity());
        assertEquals(9, vector.returnAtIndex(4));

        assertThrows(Exception.class, () -> {
            vector.changeSizeToArray(0);
        });

        vector.increaseArraySize();
        assertEquals(20, vector.capacity());

        vector.shrinkSize();
        assertEquals(5, vector.capacity());

        vector.removeElementToEnd();
        assertEquals(4, vector.size());

        for (int i = 0; i < 4; i++ ) {
            vector.removeElementToEnd();
        }

        assertEquals(0, vector.size());
        assertThrows(Exception.class, () -> {
            vector.shrinkSize();
        });
        assertThrows(Exception.class, () -> {
            vector.removeElementToEnd();
        });

        for (int i = 0; i < 14; i++ ) {
            vector.addElementToEnd(i);   
        }

        assertEquals(0, vector.returnAtIndex(0));
        vector.removeElementToIndex(0);
        assertEquals(null, vector.returnAtIndex(0));

        assertThrows(Exception.class, () -> {
            vector.removeElementToIndex(21);
        });

        vector.removeAllElements();
        assertEquals(null, vector.returnAtIndex(0));
        assertEquals(null, vector.returnAtIndex(6));

    }
}
