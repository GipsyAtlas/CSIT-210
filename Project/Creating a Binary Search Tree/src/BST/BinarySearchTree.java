package BST;

//--------------------------------------------------------//
//  BinarySearchTree class that extends BinaryTree class  //
//--------------------------------------------------------//

public class BinarySearchTree extends BinaryTree {

    //-------------------------------------//
    //  Method to insert a value into BST  //
    //-------------------------------------//
	
    public void insert(int key) {
        root = insertRec(root, key);
    }

    //----------------------------------------------------//
    //  Helper method to recursively insert into the BST  //
    //----------------------------------------------------//
    
    private BinaryTreeNode insertRec(BinaryTreeNode node, int key) {
        if (node == null) return new BinaryTreeNode(key);

        if (key < node.data) {
            node.left = insertRec(node.left, key);
        } else if (key > node.data) {
            node.right = insertRec(node.right, key);
        }

        return node;  //  return unchanged node if duplicate
    }

    //-------------------------------------//
    //  Method to delete a value from BST //
    //-------------------------------------//
    
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    //----------------------------------------------------//
    //  Helper method to recursively delete from the BST  //
    //----------------------------------------------------//
    
    private BinaryTreeNode deleteRec(BinaryTreeNode node, int key) {
        if (node == null) return null;

        if (key < node.data) {
            node.left = deleteRec(node.left, key);
        } else if (key > node.data) {
            node.right = deleteRec(node.right, key);
        } else {
            //  Node with only one child or no child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            //  Node with two children: Get inorder successor (min in right)
            node.data = minValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }

        return node;
    }

    //--------------------------------------------//
    //  Helper method to find minimum value node  //
    //--------------------------------------------//
    
    private int minValue(BinaryTreeNode node) {
        int minVal = node.data;
        while (node.left != null) {
            node = node.left;
            minVal = node.data;
        }
        return minVal;
    }
}
