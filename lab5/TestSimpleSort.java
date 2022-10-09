import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;


public class TestSimpleSort {
    
    @Test
    public void test_buble_integer() {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {0,1,2,3,4,5,6,7,8,9};
        SimpleSort.sort_buble(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_buble_integer_in_range() {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {9,2,3,4,7,8,5,6,1,0};
        
        SimpleSort.sort_buble_range(a,3,5);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_buble_generic() {
        String a[] = {"test2", "test1","test4", "test3"};
        String b[] = {"test1", "test2", "test3", "test4"};

        SimpleSort.sort_buble(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_insert_integer() {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {0,1,2,3,4,5,6,7,8,9};
        SimpleSort.sort_insert(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_insert_integer_in_range() {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {9,2,3,4,7,8,5,6,1,0};
        
        SimpleSort.sort_insert_range(a,3,5);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_insert_generic() {
        String a[] = {"test2", "test1","test4", "test3"};
        String b[] = {"test1", "test2", "test3", "test4"};

        SimpleSort.sort_insert(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_selection_integer() {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {0,1,2,3,4,5,6,7,8,9};
        SimpleSort.sort_selection(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_selection_integer_in_range() {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {9,2,3,4,7,8,5,6,1,0};
        
        SimpleSort.sort_selection_range(a,3,5);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_selection_generic() {
        String a[] = {"test2", "test1","test4", "test3"};
        String b[] = {"test1", "test2", "test3", "test4"};

        SimpleSort.sort_selection(a);
        assertArrayEquals(a, b); 
    }
}
