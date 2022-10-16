import java.lang.Exception;
import java.util.Arrays;

public class EffectiveSort {

    public static <T extends Comparable<T>> void quicksort(T arr[]) {
        quicksort(arr,0,arr.length-1);
    }

    public static <T extends Comparable<T>> void quicksort(T[] A, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(A, begin, end);
    
            quicksort(A, begin, partitionIndex-1);
            quicksort(A, partitionIndex+1, end);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] A, int begin, int end) {
        T pivot = A[end];
        int i = (begin-1);
    
        for (int j = begin; j < end; j++) {
            if (A[j].compareTo(pivot) <= 0) {
                i++;
    
                T swapTemp = A[i];
                A[i] = A[j];
                A[j] = swapTemp;
            }
        }
    
        T swapTemp = A[i+1];
        A[i+1] = A[end];
        A[end] = swapTemp;
    
        return i+1;
    }

    public static <T extends Comparable<T>> T[] heapsort(T[] A) throws Exception {
        return heapsort(A, 0, A.length-1);
    }

    public static <T extends Comparable<T>> T[] heapsort(T[] A, int left, int right) throws Exception {
        int n = right+1;
        int i = (n+left - 2) / 2;

        while (i >= left) {
            heapify(A, i--, left, n);
        }

        while (n > left)
        {
            A[n - 1] = pop(A, left, n);
            n--;
        }
        return A;
    }
    
    private static <T extends Comparable<T>> void heapify(T[] A, int i,int begin, int size ){
        int left = LEFT(i, begin);
        int right = RIGHT(i, begin);
        System.out.println(left);
        System.out.println(right);
 
        int largest = i;
        if (left < size && A[left].compareTo(A[i]) > 0) {
            largest = left;
        }
 
        if (right < size && A[right].compareTo(A[largest]) > 0) {
            largest = right;
        }

        if (largest != i)
        {
            swap(A, i, largest);
            heapify(A, largest, begin, size);
        }
    }
    
    public static <T extends Comparable<T>> T pop(T[] A, int left, int size) throws Exception {
        if (size <= left) {
            throw new Exception();
        }

        T top = A[left];
        A[left] = A[size-1];
        heapify(A, left, left, size - 1);
        return top;
    }

    private static int LEFT(int i, int begin) {
        return (2*(i-begin) + 1+ begin);
    }
    
    private static int RIGHT(int i, int begin) {
        return (2*(i-begin) + 2 + begin);
    }
 
    private static<T> void swap(T[] A, int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static<T extends Comparable<T>> T[] mergeSort(T[] A) throws Exception {
       return mergeSort(A, 0 , A.length-1);
    }

    public static<T extends Comparable<T>> T[] mergeSort(T[] A, int left, int right) throws Exception {
        if (right <= left) return A;
    
        int mid = (left+right)/2;
        mergeSort(A, left, mid);
        mergeSort(A, mid+1, right);
        return merge(A, left, mid, right);
    }

    public static <T extends Comparable<T>> T[] merge(T[] A, int left, int mid, int right) {
        T leftArray[] = Arrays.copyOfRange(A, left , mid+1);
        T rightArray[] = Arrays.copyOfRange(A, mid+1 , right+1);
    
        int leftIndex = 0;
        int rightIndex = 0;
    
        for (int i = left; i < right + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) < 0) {
                   A[i] = leftArray[leftIndex];
                   leftIndex++;
                } else {
                    A[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                A[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                A[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
        return A;
    }
}