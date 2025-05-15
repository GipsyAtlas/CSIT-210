package BST;

import java.io.*;
import java.util.*;

public class Main {

    //---------------------------------------------//
    //  Main method to read input and run the BST  //
    //---------------------------------------------//

    public static void main(String[] args) {

        //  Create a Binary Search Tree instance
        BinarySearchTree bst = new BinarySearchTree();

        //-----------------------------------------//                      //------------------------------------//
        //  Read the input.txt file with commands  //                      //  File path for the input.txt file  //
        //-----------------------------------------//                      //------------------------------------//

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\amooo\\Downloads\\CCBC\\CSIT 211\\input.txt"))) {
            String line;

            //  Read each line in the file
            while ((line = br.readLine()) != null) {
                //  Split commands by comma
                String[] commands = line.split(",");

                for (String command : commands) {
                    command = command.trim();
                    if (command.length() < 2) continue;

                    //  First character is operator (+ or -), rest is the number
                    char op = command.charAt(0);
                    int number = Integer.parseInt(command.substring(1).trim());

                    //  Perform insert or delete
                    if (op == '+') {
                        bst.insert(number);
                    } else if (op == '-') {
                        bst.delete(number);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        //------------------------------------------------------//
        //  Print the inorder traversal of distinct BST values  //
        //------------------------------------------------------//

        List<Integer> sortedValues = bst.getInorderTraversal();
        System.out.println("Inorder traversal (distinct, sorted values):");
        for (int val : sortedValues) {
            System.out.print(val + " ");
        }
    }
}
