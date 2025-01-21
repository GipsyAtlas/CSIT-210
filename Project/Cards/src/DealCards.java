import java.util.Random;
 
public class DealCards {
	public static void main(String[] args) {
		
		//--------------------------------//
		//  choosing the five random cards //
		//--------------------------------//
		Card firstCard = chooseRandomCard();
		Card secondCard = chooseRandomCard();
		Card thirdCard = chooseRandomCard();
		Card fourthCard = chooseRandomCard();
		Card fifthCard = chooseRandomCard();
		
		//-------------------------------------//
		//  display for the five random cards  //
		//-------------------------------------//
		System.out.println("Cards Dealt:");
		System.out.println(firstCard.stack());
		System.out.println(secondCard.stack());
		System.out.println(thirdCard.stack());
		System.out.println(fourthCard.stack());
		System.out.println(fifthCard.stack());
		
	}
 
	//-----------------------------------//
	//  The method for the random cards  //
	//-----------------------------------//
	private static Card chooseRandomCard() {
		Random random = new Random();
		int randomsuit= random.nextInt(4)+1;
		int randomnumface = random.nextInt(13)+1;
		return new Card(randomnumface, randomsuit);
	}
	
}