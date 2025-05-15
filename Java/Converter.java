import java.util.Scanner;
 
public class Converter {
 
    //------------------------------------------//
    //  Recursive method to convert whole part  //
    //------------------------------------------//
    public static String decimaltobinary(long n) {
        if (n == 0) return "0";
        return (n == 1) ? "1" : decimaltobinary(n / 2) + (n % 2);
    }
 
    //-----------------------------//
    //  Main method entry point  //
    //-----------------------------//
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the converter");
        while (true) {
            //---------------------------------------------//
            //  Prompt user for decimal input and convert  //
            //---------------------------------------------//
            System.out.print("Enter an integer number: ");
            long integerpart = scanner.nextLong();  //  Extract integer part
            String binaryinteger = decimaltobinary(integerpart);  //  Convert integer part
            //----------------------------------------//
            //  Display the binary conversion result  //
            //----------------------------------------//
            System.out.println("Binary number: " + binaryinteger);
            //-------------------------------------//
            //  Ask user if they want to continue  //
            //-------------------------------------//
            System.out.print("Do you want to continue converting yes or no: ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }
        //-------------------------------//
        //  Display for time complexity  //
        //-------------------------------//
        scanner.close();
        System.out.println("Time Complexity: O(log n) for integer part.");
    }
}