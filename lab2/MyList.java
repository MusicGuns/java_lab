import java.lang.Exception;

public class MyList {
    private int size;
    private Node first;
    private Node last;

    public MyList() {
        size = 0;
    }

    public MyList(MyList mylist) {
        MyList newlist = new MyList();
        Node node = this.first;
        newlist.add_first(node.item);

        for(int i = 0; i < size-1; i++ ) {
            node = node.next;
            newlist.add_last(node.item); 
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

    public static void main(String[] args) {
        MyList mylist = new MyList();

        System.out.println(mylist.first.item() + "" + mylist.first.next());
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
        last = new Node( object, null);
        return first = last;
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
}