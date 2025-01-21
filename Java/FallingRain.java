import java.util.Scanner;

public class FallingRain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //----------------------------------------------------------//
        //  User input for the number of years and input validation //
        //----------------------------------------------------------//
        
        int years = 0;
        while (true) {
            System.out.print ("Enter how many years you want to calculate: ");
            if (scan.hasNextInt()) {
                years = scan.nextInt();
                if (years < 1) {
                    System.out.println ("Enter a number greater than 0.");
                } else {
                    break;
                }
            } else {
                System.out.println ("Please enter a number.");
                scan.next();
            }
        }
 
        double inches = 0; //  Total rainfall in all the years  //
        int months = years * 12; //  The calculation for the total number of months  //
 
        //-----------------------------------------------------------------------//
        //  User input for the inches of the rain per month and input validation //
        //-----------------------------------------------------------------------//
        
        for (int year = 1; year <= years; year++) {
            System.out.println ("\nYear " + year + ":");
            double totalYear = 0; //  Total rainfall for the current year //
 
            for (int month = 1; month <= 12; month++) {
                while (true) {
                    System.out.print ("Enter the rainfall for month " + month + " of year " + year + " in inches: ");
                    if (scan.hasNextDouble()) {
                        double rainfall = scan.nextDouble();
                        if (rainfall < 0) {
                            System.out.println ("Rainfall cannot be negative number.");
                        } else {
                            totalYear += rainfall;
                            break;
                        }
                    } else {
                        System.out.println ("Please enter a number.");
                        scan.next();
                    }
                }
            }
            inches += totalYear; //  Add the overall total rainfall  //
        }
 
        //  Calculation for average rainfall  //
        double average = inches / months;
 
        //  Display message //
        System.out.println ();
        System.out.println ("The total amount of months: " + months);
        System.out.println ("The total of rainfall in inches: " + inches);
        System.out.println ("The average rainfall per month: " + average);
 
        scan.close();
    }
}