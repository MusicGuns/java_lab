import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class TestEffectiveSort {
    
    @Test
    public void test_buble_integer() {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {0,1,2,3,4,5,6,7,8,9};
        EffectiveSort.quicksort(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_buble_integer_in_range() {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {9,2,3,4,7,8,5,6,1,0};
        
        EffectiveSort.quicksort(a,3,5);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_buble_generic() {
        String a[] = {"test2", "test1","test4", "test3"};
        String b[] = {"test1", "test2", "test3", "test4"};

        EffectiveSort.quicksort(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_insert_integer() throws Exception{
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {0,1,2,3,4,5,6,7,8,9};
        EffectiveSort.heapsort(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_insert_integer_in_range() throws Exception {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {9,2,3,4,7,8,5,6,1,0};
        
        EffectiveSort.heapsort(a,3,5);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_insert_generic() throws Exception {
        String a[] = {"test2", "test1","test4", "test3"};
        String b[] = {"test1", "test2", "test3", "test4"};

        EffectiveSort.heapsort(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_selection_integer() throws Exception {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {0,1,2,3,4,5,6,7,8,9};
        EffectiveSort.mergeSort(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_selection_integer_in_range() throws Exception {
        Integer a[] = {9,2,3,7,8,4,5,6,1,0};
        Integer b[] = {9,2,3,4,7,8,5,6,1,0};
        
        EffectiveSort.mergeSort(a,3,5);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_selection_generic() throws Exception {
        String a[] = {"test2", "test1","test4", "test3"};
        String b[] = {"test1", "test2", "test3", "test4"};

        EffectiveSort.mergeSort(a);
        assertArrayEquals(a, b); 
    }
}
