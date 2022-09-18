import static org.junit.Assert.*;
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
}
