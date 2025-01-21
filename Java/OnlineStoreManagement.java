import java.util.Scanner;

public class OnlineStoreManagement {

	public static void main(String[] args) {
		
		//---------------------//
		//  Customer Greeting  //
		//---------------------//
		
		// Declared string for greeting message, customer's name, and full greeting.
		String greeting = "Welcome to my store";
		String customersname = "David";
	    String fullgreeting = greeting + " " + customersname;
		
	    // The print for the concatenated greeting and updated greeting.
	    System.out.println (fullgreeting);
	    
	    System.out.println ();
	    
	    System.out.println (greeting + "\n" + customersname);
	    
	    System.out.println ();
		
		//------------------------//
		//  Inventory Management  //
		//------------------------//
		
		// String for my item name, if it is in stock, and the amount in stock
		String itemname = "GamingPc";
		double itemprice = 700;
		int quantityavailable = 60;
		
		// The print for my item name, if it is in stock, and the amount in stock
		System.out.println ("I am selling a " + itemname);
		System.out.println ("My price is " + itemprice);
		System.out.println ("The amount I have in stock is " + quantityavailable);
		
		System.out.println ();
		
		//--------------------------//
		//  Financial Calculations  //
		//--------------------------//
		
		int quantitiessold = 40;
		int quantitiesreturned = 6;
		int unitprice = 680;
        int discountrate = 1;
        
        int totalsales = quantitiessold * unitprice;
        int totalreturns = quantitiesreturned * unitprice;
        int netsales = totalsales - totalreturns;
        int discountedsales = netsales * (1 - discountrate);
        
        System.out.println ("My total sales are " + totalsales);
        System.out.println ("My total returns are " + totalreturns);
        System.out.println ("My net sales are " + netsales);
        System.out.println ("My discounted sales are " + discountedsales);
        
        System.out.println ();
        
        //-----------------------//
        //  Currency Conversion  //
        //-----------------------//
        
        int usdamount = 100;
        double eurconversionrate = 0.90;
        double euramount = usdamount * eurconversionrate;
        System.out.println (usdamount + " in USD is " + euramount + " in EUR");
        
        double gbpamount = 76.00;
        double  usdconversionrate = 1 / 0.76;
        int equivalent = (int) (gbpamount * usdconversionrate);
        System.out.println (gbpamount + " in GBP is " + equivalent + " in USD");
        
        System.out.println ();
        
        String numericvalue1 = "150";
        int intvalue = Integer.parseInt(numericvalue1);
        System.out.println ("An int value: " + intvalue);
        
        String numericvalue2 = "150";
        double doublevalue = Double.parseDouble(numericvalue2);
        System.out.println ("A double value: " + doublevalue);
        
        System.out.println ();
        
        //------------------------//
        //  Customer Interaction  //
        //------------------------//
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scan.nextLine();
        
        System.out.print("Enter your membership ID: ");
        int membershipID = scan.nextInt();

        System.out.print("Enter your total purchase amount: ");
        double purchaseamount = scan.nextDouble();
        
        System.out.println();
        
        System.out.println ("Customer's name is " + name + ", customer's membershipID is " + membershipID + ", and the total amount the customer perchased is " + purchaseamount);
	}

}