import java.util.Scanner;
 
public class CookoutCalculator {
 
    public static void main(String[] args) {
        
    	//----------------------------------------------------------------------------//
        //  User input for name, number of people, and number of hot dogs per person  //
    	//----------------------------------------------------------------------------//
    	
        Scanner scan = new Scanner(System.in);
        System.out.print ("Enter your name: ");
        String name = scan.nextLine();
 
        System.out.print ("How many people are going to be at this cookout: ");
        int amountOfPeople = scan.nextInt();
 
        System.out.print ("How many hotdogs will each person be getting: ");
        int hotdogsPerPerson = scan.nextInt();
 
         scan.close();
 
        //--------------- //
        //  Calculations  //
        //----------------//
    
        int hotdogsPack = 10;
        int hotdogsBunsPack = 8;
        int totalHotdogs = amountOfPeople * hotdogsPerPerson;
 
        int hotdogsNeeded = (totalHotdogs + hotdogsPack - 1) / hotdogsPack;
        int hotdogsLeft = (hotdogsNeeded * hotdogsPack) - totalHotdogs;
 
        int hotdogsBunsNeeded = (totalHotdogs + hotdogsBunsPack - 1) / hotdogsBunsPack;
        int hotdogsBunsLeft = (hotdogsBunsNeeded * hotdogsBunsPack) - totalHotdogs;
 
 
        //------------------//
        //  Display messages//
        //------------------//
        
        System.out.println ("Hey " + name + ",");
        System.out.println ("The minimum amount of hotdogs packages you'll need are: " + hotdogsNeeded);
        System.out.println ("The minimum amount of hotdogs buns packages you'll need are: " + hotdogsBunsNeeded);
        System.out.println ("The amount of hotdogs that will be left are: " + hotdogsLeft);
        System.out.println ("The amount of hotdogs buns that will be left are: " + hotdogsBunsLeft);
    }
}