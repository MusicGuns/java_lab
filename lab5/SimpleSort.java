

public class  SimpleSort<T> {

    public static <T extends Comparable<T>> T[] sort_buble_range(T a[], int left, int right){
        for (int out = right-1; out >= left; out--){  
            for (int in = left; in <= out; in++){       
                if(a[in].compareTo(a[in + 1]) > 0) {
                    T tmp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = tmp;            
                }               
            }
        }
        return a;
    }

    public static <T extends Comparable<T>> T[] sort_buble(T a[]){
        return sort_buble_range(a, 0, a.length - 1);
    }
    
    public static <T extends Comparable<T>> T[] sort_insert_range(T a[], int left, int right){
        for (int i = left+1; i < right+1; i++) { 
            T key = a[i]; 
            int j = i - 1;
            while (j >= left && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key; 
        }
        return a;
    }

    public static <T extends Comparable<T>> T[] sort_insert(T a[]){
        return sort_insert_range(a, 0, a.length - 1);
    }

    public static <T extends Comparable<T>> T[] sort_selection_range(T a[], int left, int right){
        for (int i = right; i >= left; i--) {
            int maxId = i;
            for (int j = i-1; j >= left; j--) {
                if (a[j].compareTo(a[maxId]) > 0) {
                    maxId = j;
                }
            }

            T temp = a[i];
            a[i] = a[maxId];
            a[maxId] = temp;
        }
        return a;
    }

    public static <T extends Comparable<T>> T[] sort_selection(T a[]){
        return sort_selection_range(a, 0, a.length - 1);
    }
}
