import java.util.Scanner;

public class CaloriesCalculator {

	public static void main(String[] args) {
		
		int cookies = 40;
		int servingsperbag = 10;
		int calories = 300;
				
        Scanner scan = new Scanner(System.in);
        
        System.out.println ("How many cookies have you had:"); //user input how many cookies they had.
        int cookieshad = scan.nextInt();
        
        int caloriespercookie = calories / (cookies / servingsperbag); //calculation to find out how much calories is in one cookie.
        
        int caloriesconsumed = cookieshad * caloriespercookie; //multiplying how much cookies user had by the amount of calories per cookies.
        
        System.out.println();
        
        System.out.println ("The amount of calories that you have consumed is: " + caloriesconsumed); //display message of how much calories the user has consumed.
        
        scan.close();
	}

}
