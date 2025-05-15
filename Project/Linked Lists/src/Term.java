
public class Term {
    //----------------------------------------//
    //  Instance variables for Term class     //
    //----------------------------------------//
    
    int coefficient, exponent; //  Coefficient and exponent of the term
    Term next; //  Reference to the next term in the polynomial

    //----------------------------------//
    //  Constructor for the Term class  //
    //----------------------------------//

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient; //  Initialize coefficient
        this.exponent = exponent;       //  Initialize exponent
        this.next = null;               //  Set next term to null
    }
}  
