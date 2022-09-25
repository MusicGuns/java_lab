import static org.junit.Assert.*;
import org.junit.Test;

public class TestBinaryTree {
    /**
     * 
     */
    @Test
    public void test1() {
        BinaryTree<Integer> myTree = new BinaryTree<Integer>();
        assertEquals(0, myTree.count());
        myTree.add(-1);
        assertEquals(1, myTree.count());
        assertEquals(Integer.valueOf(-1), myTree.first().item);
        
        for (int i = 0; i < 100; i++) {
            myTree.add(i);
        }
        assertEquals(Integer.valueOf(99), myTree.find_element(99).item);

        BinaryTree<Integer> newTree = new BinaryTree<Integer>(myTree);
        assertEquals(newTree.first().right_next().item(), myTree.first().right_next().item());
        assertEquals(newTree.find_element(50).item, Integer.valueOf(50));

        assertEquals(0, myTree.add(0));
        myTree.delete_all();
        assertEquals(myTree.first(), null);
        assertEquals(myTree.count(), 0);
      }
}