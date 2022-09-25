@SuppressWarnings("unchecked")
public class BinaryTree<T> {
    private int count;
    private Node<T> first;
    
    public BinaryTree() {
        count = 0;
    }

    public BinaryTree(T object) {
        count = 1;
        first = init_add(object);
    }
    
    public BinaryTree(BinaryTree<T> myBinary) {
        count = 1;
        first = init_add(myBinary.first.item);
        to_next_copy(first.right_next = new Node(null,null,null), myBinary.first.right_next());
        to_next_copy(first.left_next = new Node(null,null,null), myBinary.first.left_next());
    }

    public Node<T> first() {
        return first;
    }

    public int count() {
        return count;
    }

    private void to_next_copy(Node<T> newNode,Node<T> oldNode) {
        newNode.item = oldNode.item();
        count+=1;
        if (oldNode.right_next() != null) {
            to_next_copy(newNode.right_next = new Node(null,null,null), oldNode.right_next());
        }

        if (oldNode.left_next() != null) {
            to_next_copy(newNode.left_next = new Node(null,null,null), oldNode.left_next());
        }
    }

    public Object add(T object) {
        count +=1;
        if (count == 1) {
            return init_add(object);
        }
        Node<T> node = find_void_place(first);
        node.item = object;
        return node.item;
    }

    private Node<T> find_void_place(Node<T> node) {
        if (node.right_next == null) {
            return node.right_next = new Node<T>(null, null, null);
        } else if (node.left_next == null) {
            return node.left_next = new Node<T>(null, null, null);
        } else {
            return getRandomDoubleBetweenRange(0,2) > 1 ? find_void_place(node.right_next) : find_void_place(node.left_next);
        }
    }

    private static double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return x;
    }

    public Node<T> find_element(T object) {
        if (first.item == object) {
            return first;
        }
     
        if (first.right_next == null && first.left_next == null) {
            return null;
        } else if(first.right_next != null) {
            return find_next_element(first.right_next, object) != null ? find_next_element(first.right_next, object) : first.left_next != null ? find_next_element(first.left_next, object) : null;
        } else {
            return null;
        }
    }

    private Node<T> find_next_element(Node<T> node, T object) {
        if (node.item == object) {
            return node;
        }

        if (node.right_next == null && node.left_next == null) {
            return null;
        } else if(node.right_next != null && find_next_element(node.right_next, object) != null) {
            return find_next_element(node.right_next, object);
        }else if(node.left_next != null && find_next_element(node.left_next, object) != null){
            return find_next_element(node.left_next, object);
        } else {
            return null;
        }
    }

    private Node<T> init_add(T object) {
        return first = new Node<T>( object, null, null);
    } 

    public void delete_all() {
        first = null;
        count = 0;
    }

    public static class Node<T> {
        T item;
        Node<T> right_next;
        Node<T> left_next;
        
        Node(T element, Node<T> right_next, Node<T> left_next) {
            this.item = element;
            this.right_next = right_next;
            this.left_next = left_next;
        }

        public T item() {
            return item;
        }

        
        public Node<T> right_next() {
            return right_next;
        }

        public Node<T> left_next() {
            return left_next;
        }
    }
}