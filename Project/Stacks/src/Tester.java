import java.util.Scanner;

public class Tester {

    //------------------------------------------------------//
    //  Main method to test stack and evaluate expressions  //
    //------------------------------------------------------//
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //------------------------------------------------------//
        //  Ask the user for stack size and initialize MyStack  //
        //------------------------------------------------------//
        
        System.out.print("Enter the stack amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); //  Consume the leftover newline
        MyStack MyStack = new MyStack(amount);
        
        //-------------------------------------//
        //  Menu options for stack operations  //
        //-------------------------------------//
        
        int choice;
        do {
            System.out.println("============================");
            System.out.println("Choose from the menu:");
            System.out.println("1. Push.");
            System.out.println("2. Pop.");
            System.out.println("3. Peak.");
            System.out.println("4. Exit.");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    //  Request input from user to push onto the stack
                    System.out.print("Enter an integer to add to the stack: ");
                    String element = scanner.nextLine();
                    MyStack.push(element); //  Add element to stack
                    MyStack.display(); //  Show updated stack
                    break;
                case 2:
                    //  Remove the top element and display it
                    String popped = MyStack.pop();
                    if (popped != null) {
                        System.out.println(popped + " has been removed from the stack.");
                    }
                    MyStack.display(); //  Show updated stack
                    break;
                case 3:
                    //  Display the top element without removing it
                    String top = MyStack.peak();
                    if (top != null) {
                        System.out.println("The element at the top is: " + top);
                    }
                    MyStack.display(); //  Show updated stack
                    break;
                case 4:
                    //  Print the final stack state before closing
                    System.out.println("Final stack state before exiting:");
                    MyStack.display();
                    System.out.println("Closing the stack program.");
                    break;
                default:
                    //  Inform user of invalid selection
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
        
        //-------------------------------------------//
        //  Get an infix expression and evaluate it  //
        //-------------------------------------------//
        
        boolean continueexpr = true;
        while (continueexpr) {
            System.out.print("Enter an Infix expression: ");
            String Infix = scanner.nextLine();
            String Postfix = InfixToPostfix.convert(Infix); //  Convert infix to postfix
            System.out.println("Postfix notation of the expression: ");
            System.out.println(Postfix);
            int result = PostfixEvaluator.evaluate(Postfix); //  Compute the result
            System.out.println("Computed result: " + result);
            
            // Ask user if they want to continue
            System.out.print("Do you want to continue yes or no: ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                continueexpr = false;
            }
        }
        
        //------------------------------//
        //  Close the scanner resource  //
        //------------------------------//
        
        scanner.close();
    }
}