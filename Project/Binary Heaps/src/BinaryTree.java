
public class BinaryTree {

    //-----------------------------------------//
    //  Protected instance variables for heap  //
    //-----------------------------------------//

    protected int[] heap;
    protected int size;

    //--------------------------------------//
    //  Constructor to initialize the heap  //
    //--------------------------------------//

    public BinaryTree(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    //----------------------------------------------------//
    //  Public method to start pre-order traversal print  //
    //----------------------------------------------------//

    public void iteratorPreOrder() {
        preOrderTraversal(0);
        System.out.println();
    }

    //---------------------------------------------------//
    //  Recursive method to perform pre-order traversal  //
    //---------------------------------------------------//

    private void preOrderTraversal(int index) {
        if (index >= size) return;

        System.out.print(heap[index] + " ");  //  Visit current node
        preOrderTraversal(2 * index + 1);  //  Traverse left child
        preOrderTraversal(2 * index + 2);  //  Traverse right child
    }
}
