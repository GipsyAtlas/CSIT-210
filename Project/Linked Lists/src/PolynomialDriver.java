import java.util.Scanner;

public class PolynomialDriver {
    //--------------------------------------------------//
    //  Main method for running the Polynomial program  //
    //--------------------------------------------------//

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Function to create a polynomial from user input
        Polynomial p1 = readPolynomial(scanner, "First");
        Polynomial p2 = readPolynomial(scanner, "Second");

        //  Display polynomials
        System.out.println("Polynomial 1: " + p1);
        System.out.println("Polynomial 2: " + p2);

        //  Add polynomials and display result
        Polynomial total = p1.add(p2);
        System.out.println("Total: " + total);

        //  Evaluate polynomials
        System.out.print("Enter a value for X to evaluate Polynomial 1: ");
        int x1 = scanner.nextInt();
        System.out.println("P1(" + x1 + ") = " + p1.evaluate(x1));

        System.out.print("Enter a value for X to evaluate Polynomial 2: ");
        int x2 = scanner.nextInt();
        System.out.println("P2(" + x2 + ") = " + p2.evaluate(x2));

        scanner.close();
    }

    //-------------------------------------------------//
    //  Helper method to read a polynomial from input  //
    //-------------------------------------------------//

    private static Polynomial readPolynomial(Scanner scanner, String order) {
        System.out.println("Enter terms for the " + order + " polynomial (format: coefficient exponent and enter -1 if you want to stop and also leave a space between each number when you put them in.):");
        Polynomial poly = new Polynomial();
        while (true) {
            int coefficient = scanner.nextInt();
            if (coefficient == -1) break;
            int exponent = scanner.nextInt();
            poly.addTerm(coefficient, exponent); //  Add term to polynomial
        }
        return poly; //  Return the created polynomial
    }
}
