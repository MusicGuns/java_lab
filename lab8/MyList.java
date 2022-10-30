import java.lang.Exception;

import java.util.Iterator;

import javax.xml.stream.events.EndDocument;

public class MyList {
    private int size;
    private Node first;
    private Node last; 

    public MyList() {
        size = 0;
    }

    public Myiterator iterator() {
        return new Myiterator();
    }
    
    public MyList(Object object) {
        size = 0;
        init_add(object);
    }

    public MyList(MyList mylist) {
        size = 0;
        Node node = mylist.first;
        add_first(node.item);

        for(int i = 0; i < size-1; i++ ) {
            node = node.next;
            add_last(node.item); 
        }
    }

    public Node last() {
        return last;
    }

    public Node first() {
        return first;
    }

    public int size() {
        return size;
    }

    public Node add_first(Object object) {
        size +=1;
        if (size == 1) {
            return init_add(object);
        }
        return first = new Node(object, first);
    }

    public Node add_last(Object object) {
        size +=1;
        if (size == 1) {
            return init_add(object);
        }

        last.next = new Node(object, null);
        return last = last.next();
    }

    private Node init_add(Object object) {
        first = new Node( object, null);
        return last = first;
    } 

    public Node delete_first() throws Exception {
        if (size==0) {
            throw new Exception(); 
        }

        size -=1;

        if(size == 0) {
            first = null;
            last = null;
            return null;
        }

        return first = first.next;
    }

    public Node delete_last() throws Exception {
        if (size==0) {
            throw new Exception(); 
        }

        Node node = first;
        for(int i=0; i<size-2; i++) {
            node = node.next();
        }

        size--;
        node.next = null;

        if(size == 0) {
            first = null;
            last = null;
            return null;
        }

        return last = node;
    }

    public Node delete(int ptr) throws Exception {
        if (ptr > size) {
            throw new Exception();
        } else if (ptr == size) {
            return delete_last();
        } else if (ptr == 0) {
            return delete_first();
        }

        Node node = first;
        for(int i = 0; i < ptr - 1; i++) {
            node = node.next();
        }

        size--;
        return node.next = node.next().next();
    }
    public void delete_all() {
        first = null;
        last = null;
        size = 0;
    }

    static class Node {
        Object item;
        Node next;
        
        Node(Object element, Node next) {
        this.item = element;
        this.next = next;
        }

        public Object item() {
        return item;
        }

        
        public Node next() {
        return next;
        }
    }

    public class Myiterator implements Iterator{
        private Node current;

        public Myiterator() {
            current = first;
        }

        public boolean hasNext() {
            return (current.next() != null);
        }

        public Object next() {
            Object data = current.item();
            if (hasNext()) {
                current = current.next();
            }
            return data;
        }

        public Object first() {
            Object data = first.item();
            current = first;
            return data;
        }

        public Object last() {
            Object data = last.item();
            current = last;
            return data;
        }
    }
}