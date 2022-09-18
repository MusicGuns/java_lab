import static org.junit.Assert.*;
import org.junit.Test;

public class TestVector {
    @Test
    public void test1() throws Exception {
        MyVector vector = new MyVector();
        assertEquals(0, vector.size());
        assertEquals(10, vector.capacity());
        assertEquals(10, vector.objectArray.length);
    }

    @Test
    public void test2() throws Exception {
        MyVector vector = new MyVector(new Object[] {1,"array",2.33,4});
        assertEquals(4, vector.size());
        assertEquals(18, vector.capacity());
        assertEquals(18, vector.objectArray.length);

        MyVector vector1 = new MyVector(vector);
        assertEquals(4, vector1.size());
        assertEquals(18, vector1.capacity());
        assertEquals(18, vector1.objectArray.length);
    }

    @Test
    public void test3() throws Exception {
        MyVector vector = new MyVector(new Object[] {1,"array",2.33,4});
        vector.addElementToEnd("ez");
        assertEquals(5, vector.size());
        assertEquals(18, vector.capacity());
        assertEquals(18, vector.objectArray.length);
        assertEquals("ez", vector.returnAtIndex(4));
        for (int i = 0; i < 14; i++ ) {
            vector.addElementToEnd(i);   
        }
        assertEquals(19, vector.size());
        assertEquals(46, vector.capacity());
        assertEquals(46, vector.objectArray.length);

        vector.addElementToIndex(100, 17);
        assertEquals(100, vector.returnAtIndex(17));
        assertThrows(Exception.class, () -> {
            vector.addElementToIndex(100, 20);
        });

        vector.changeSizeToArray(5);
        assertEquals(5, vector.size());
        assertEquals(5, vector.capacity());
        assertEquals("ez", vector.returnAtIndex(4));

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
