import java.util.Arrays;

import java.lang.Exception;

class MyVector {
    Object[] objectArray;
    int size;
    int capacity;

    public MyVector(Object[] beginArray) {
        objectArray = Arrays.copyOf(beginArray, beginArray.length*2+10);
        size = beginArray.length;
        capacity = 2*size+10;
    }

    public MyVector() {
        objectArray = new Object[10];
        size = 0;
        capacity = 10;
    }

    public MyVector( MyVector myVector ) {
        objectArray = Arrays.copyOf(myVector.objectArray, myVector.objectArray.length );
        size = myVector.size;
        capacity = myVector.capacity;
    }

    public Object returnAtIndex(int i) {
        return objectArray[i];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void addElementToEnd(Object a) {
        if (size == capacity) {
            increaseArraySize();
        }
        objectArray[size] = a;
        size++;
    }

    public void addElementToIndex(Object a, int i) throws Exception {
        if (i > size) {
            throw new Exception(); 
        }

        objectArray[i] = a;
    }

    public void increaseArraySize() {
        Object[] tempArray = null;

        if (size == capacity) {
            tempArray = new Object[capacity * 2 + 10];
        }
        System.arraycopy(objectArray, 0, tempArray, 0, capacity);

        objectArray = tempArray;
        capacity = capacity * 2 + 10;
    }

    public void changeSizeToArray(int i) throws Exception {
        Object[] tempArray = null;
        if (i > 0) {
            tempArray = new Object[i];
            System.arraycopy(objectArray, 0, tempArray, 0, i);
    
            objectArray = tempArray;
            capacity = i;

            if (i < size) {
                size = i;
            }
        } else {
            throw new Exception();
        }
    }


    public void shrinkSize() throws Exception {
        Object[] temp;
        if (size > 0) {
            temp = new Object[size];
            System.arraycopy(objectArray, 0, temp, 0, size);
            capacity = size;
            objectArray = temp;
        } else {
            throw new Exception();
        }
    }

    public void removeElementToIndex(int i) throws Exception {
        if (i < capacity) {
            objectArray[i] = null;
        } else {
            throw new Exception();
        }
    }

    public void removeElementToEnd() throws Exception {
        if (size > 0) {
            objectArray[size - 1] = null;
            size--;
        } else {
            throw new Exception();
        }
    }

    public void removeAllElements() {
       Object[] tempArray = new Object[capacity];
       objectArray = tempArray; 
    }

}