import java.util.Scanner;
 
public class Fibonacci {
 
	public static void main(String[] args) {
		
		//-------------------//
		//  Welcome message  //
		//-------------------//
		
		System.out.println("Hey! I am going to be helping you generate the Fibonacci series up to a specified number of terms");
		
		Scanner scan = new Scanner(System.in);
		
		//-------------------------------------//
		//  User input of the number of terms  //
		//-------------------------------------//
		
		System.out.println("Enter the number of terms you want for the Fibonacci Series: ");
		int userInput = scan.nextInt();
		
		int first = 0;
		int second = 1;
		
		//-----------------------//
		//  Loop for the series  //
		//-----------------------//
		
		for (int i = 1; i <= userInput; i++) {
			System.out.println(first);
			
			int sum = first + second;
			
			first = second;
			second = sum;
			
		}
		
		scan.close();
	}
 
}