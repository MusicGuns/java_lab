import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class TestLinSort {

    @Test
    public void test_lsd_small() {
        int a[] = {9,2,3,7,8,4,5,6,1,0};
        int b[] = {0,1,2,3,4,5,6,7,8,9};
        LinSort.sort_LSD(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_lsd_large() {
        int a[] = {923,243,332,732,834,478,598,633,145,47};
        int b[] = {47,145,243,332,478,598,633,732,834,923};
        
        LinSort.sort_LSD(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_msd_small() {
        int a[] = {9,2,3,7,8,4,5,6,1,0};
        int b[] = {0,1,2,3,4,5,6,7,8,9};
        LinSort.sort_MSD(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_msd_large() {
        int a[] = {923,243,332,732,834,478,598,633,145,47};
        int b[] = {47,145,243,332,478,598,633,732,834,923};
        
        LinSort.sort_MSD(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_counting_small() {
        int a[] = {9,2,3,7,8,4,5,6,1,0};
        int b[] = {0,1,2,3,4,5,6,7,8,9};
        LinSort.sort_Count(a);
        assertArrayEquals(a, b); 
    }

    @Test
    public void test_counting_large() {
        int a[] = {923,243,332,732,834,478,598,633,145,47};
        int b[] = {47,145,243,332,478,598,633,732,834,923};
        
        LinSort.sort_Count(a);
        assertArrayEquals(a, b); 
    }
}
