import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class TestList {
    @Test
    public void test1() throws Exception {
        MyList mylist = new MyList();
        mylist.add_first(Integer.valueOf(5));
        mylist.add_first("test");
        mylist.add_first(2.33);

        assertEquals(2.33, mylist.first().item());
        assertEquals(5, mylist.last().item());

        mylist.delete_first();
        assertEquals("test", mylist.first().item());
        mylist.delete_last();
        assertEquals("test", mylist.last().item());
        mylist.delete_first();

        assertThrows(Exception.class, () -> {
            mylist.delete_first();
        });
        assertThrows(Exception.class, () -> {
            mylist.delete_last();
        });
    }

    @Test
    public void test2() throws Exception {
        MyList mylist = new MyList();
        mylist.add_first(Integer.valueOf(5));
        mylist.add_first("test");
        mylist.add_first(2.33);
        mylist.delete(3);
        assertEquals("test", mylist.last().item());
    }

    @Test
    public void testIterator() throws Exception {
        MyList mylist = new MyList();
        mylist.add_first(5);
        mylist.add_first("test");
        mylist.add_first(2.33);
        // [2.33, "test", 5]

        MyList.Myiterator iter = mylist.iterator();
        assertEquals(2.33, iter.next());
        assertEquals("test", iter.next());
        assertEquals(5, iter.next());
        assertEquals(false, iter.hasNext());
        assertEquals(2.33, iter.first());
        assertEquals(5, iter.last());
        assertEquals(false, iter.hasNext());
    }
}
