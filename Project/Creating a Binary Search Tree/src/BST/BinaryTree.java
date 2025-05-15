package BST;

import java.util.*;

//-----------------------------------------------------//
//  Class representing the base Binary Tree structure  //
//-----------------------------------------------------//

class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    //--------------------------------------//
    //  Constructor to initialize a node   //
    //--------------------------------------//
    
    public BinaryTreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {

    //------------------------------------------//
    //  Root node for the binary tree (protected)
    //------------------------------------------//
	
    protected BinaryTreeNode root;

    //-----------------------------------//
    //  Constructor for BinaryTree class //
    //-----------------------------------//
    
    public BinaryTree() {
        root = null;
    }

    //-------------------------------------------------//
    //  Recursive inorder traversal to collect values  //
    //-------------------------------------------------//
    
    public void inorderTraversal(BinaryTreeNode node, List<Integer> result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.add(node.data);
            inorderTraversal(node.right, result);
        }
    }

    //----------------------------------------------------------//
    //  Public method to start traversal and return value list  //
    //----------------------------------------------------------//
    
    public List<Integer> getInorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
}
