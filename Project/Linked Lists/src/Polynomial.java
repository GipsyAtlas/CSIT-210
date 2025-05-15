
public class Polynomial {
    //------------------------------------------//
    //  Instance variable for Polynomial class  //
    //------------------------------------------//
    
    private Term head; //  Head of the linked list representing the polynomial

    //--------------------------------------------//
    //  Default constructor for Polynomial class  //
    //--------------------------------------------//

    public Polynomial() {
        this.head = null; //  Initialize an empty polynomial
    }

    //-----------------------------------------//
    //  Constructor for a constant polynomial  //
    //-----------------------------------------//

    public Polynomial(int coefficient) {
        this.head = new Term(coefficient, 0); //  Create a constant term with exponent 0
    }

    //------------------------------------------//
    //  Method to add a term to the polynomial  //
    //------------------------------------------//

    public void addTerm(int coefficient, int exponent) {
        if (coefficient == 0) return; //  Ignore zero coefficients

        Term newNode = new Term(coefficient, exponent); //  Create new term
        if (head == null || exponent > head.exponent) {
            newNode.next = head;
            head = newNode; //  Insert new term at the beginning if head is null or exponent is higher
            return;
        }

        Term current = head, prev = null;
        while (current != null && current.exponent > exponent) {
            prev = current;
            current = current.next; //  Traverse to the right position based on exponent
        }

        if (current != null && current.exponent == exponent) {
            current.coefficient += coefficient; //  Combine terms with the same exponent
            if (current.coefficient == 0) {
                if (prev != null) prev.next = current.next; //  Remove term if coefficient is zero
                else head = current.next;
            }
        } else {
            newNode.next = current;
            if (prev != null) prev.next = newNode; //  Insert new term at the correct position
        }
    }

    //---------------------------------//
    //  Method to add two polynomials  //
    //---------------------------------//

    public Polynomial add(Polynomial other) {
        Polynomial result = new Polynomial(); //  Result polynomial for storing sum
        Term p1 = this.head, p2 = other.head;

        while (p1 != null || p2 != null) {
            int coefficient, exponent;
            if (p2 == null || (p1 != null && p1.exponent > p2.exponent)) {
                coefficient = p1.coefficient;
                exponent = p1.exponent;
                p1 = p1.next; //  Take term from p1 if p2 is null or p1's exponent is greater
            } else if (p1 == null || (p2 != null && p2.exponent > p1.exponent)) {
                coefficient = p2.coefficient;
                exponent = p2.exponent;
                p2 = p2.next; //  Take term from p2 if p1 is null or p2's exponent is greater
            } else {
                coefficient = p1.coefficient + p2.coefficient;
                exponent = p1.exponent;
                p1 = p1.next;
                p2 = p2.next; //  Add terms if exponents are equal
            }
            result.addTerm(coefficient, exponent); //  Add resulting term to polynomial
        }
        return result;
    }

    //------------------------------------------//
    //  Method to evaluate the polynomial at x  //
    //------------------------------------------//

    public int evaluate(int x) {
        int result = 0;
        Term current = head;
        while (current != null) {
            result += current.coefficient * Math.pow(x, current.exponent); //  Evaluate term for given x
            current = current.next; //  Move to the next term
        }
        return result;
    }

    //--------------------------------------------------------------//
    //  Method to return a string representation of the polynomial  //
    //--------------------------------------------------------------//

    public String toString() {
        if (head == null) return "0"; //  Return "0" if polynomial is empty
        StringBuilder sb = new StringBuilder();
        Term current = head;
        while (current != null) {
            if (sb.length() > 0 && current.coefficient > 0) sb.append(" + ");
            else if (current.coefficient < 0) sb.append(" - ");

            sb.append(Math.abs(current.coefficient));
            if (current.exponent > 0) sb.append("x");
            if (current.exponent > 1) sb.append("^").append(current.exponent);
            current = current.next; //  Move to the next term
        }
        return sb.toString(); //  Return polynomial as a string
    }
}
