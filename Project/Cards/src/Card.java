public class Card {
    private int numface;
    private int suit;
    
    public Card(int numface, int suit) {
        this.numface = numface;
        this.suit = suit;
    }
    
    
    //----------------------------//
    // string of the ace to king  //
    //----------------------------//
    public String numfaceValue() {
        switch (numface) {
            
        case 1:
        	return "Ace";
        case 2:
        	return "Two";
        case 3:
        	return "Three";
        case 4:
        	return "Four";
        case 5:
        	return "Five";
        case 6:
        	return "Six";
        case 7:
        	return "Seven";
        case 8:
        	return "Eight";
        case 9:
        	return "Nine";
        case 10:
        	return "Ten";
        case 11:
        	return "Jack";
        case 12:
        	return "Queen";
        case 13:
        	return "King";
        default:
        	return "invalid";
        }
    }
    
    //----------------------------------------------------//
    //  string of the clubs, diamond, hearts, and spades  //
    //----------------------------------------------------//
    public String suitValue() {
        switch (suit) {
            
        case 1:
        	return "Clubs";
        case 2:
        	return "Diamonds";
        case 3: 
        	return "Hearts";
        case 4: 
        	return "Spades";
        default:
        	return "invalid";
        }
    }
    
    public String stack() {
        return numfaceValue() + " of " + suitValue();
    }
}