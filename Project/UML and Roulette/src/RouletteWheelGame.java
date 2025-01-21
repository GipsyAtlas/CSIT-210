import java.util.Scanner;

public class RouletteWheelGame {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//------------------------------------//
		//  User input for the pocket number  //
		//------------------------------------//
		System.out.print("Enter a pocket number ranging from 0 to 36:");
		System.out.println();
		int RouletteWheelGame = scan.nextInt();
		
		if (RouletteWheelGame >= 0 && RouletteWheelGame <= 36) {
			RoulettePocket pocket = new RoulettePocket(RouletteWheelGame);
			System.out.println("The color for number " + RouletteWheelGame + " is " + pocket.getPocketColor() + "."); // The result of the color based of the number  //
		} else {
			System.out.println("The pocket number must be between 0 and 36. Try again."); //  Input validation  loop  //
		}
		
		scan.close();
	}
}