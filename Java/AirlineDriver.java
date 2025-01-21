import java.util.Scanner;

public class AirlineDriver {
    public static void main(String[] args) {
        char[][] layout = {
            {'A', 'B', 'C', 'D'},    //----------------------//
            {'A', 'B', 'C', 'D'},    // layout of the seats  //
            {'A', 'B', 'C', 'D'},    //----------------------//
            {'A', 'B', 'C', 'D'},
            {'A', 'B', 'C', 'D'}
        };

        Scanner scan = new Scanner(System.in);
                                     //------------------------------//
        while (true) {               //  User input the chosen seat  //
            displaySeats(layout);    //------------------------------//
            System.out.print ("Please chose a row from 1 to 5 and a seat from A to D or enter -1 to stop: ");
            String seatinput = scan.nextLine().toUpperCase();

            if (seatinput.equals("-1")) break;

            int row = seatinput.charAt(0) - '1';  //  The index for the row  //
            int col = seatinput.charAt(1) - 'A';  //  The index for the col  //
                                                                 //-------------------------------------------------------//
            if (row >= 0 && row < 5 && col >= 0 && col < 4) {    //  Display if user inputs a seat that is already taken  //
                if (layout[row][col] == 'X') {                   //-------------------------------------------------------//
                    System.out.println ("This seat " + seatinput + " is already assigned, Chose another seat.");
                } else {
                    layout[row][col] = 'X';    //----------------------------------------------------//
                }                              //  Display if user inputs a seat that doesn't exist  //
            } else {                           //----------------------------------------------------//
                System.out.println ("That seating position doesn't exist, Please enter an available row and seat.");
            }
        }

        scan.close();
    }

    //----------------------------------------------//
    //  Display of the current seating arrangement  //
    //----------------------------------------------//
    public static void displaySeats(char[][] plane) {
        System.out.println ("The seating arrangement layout:");
        for (int row = 0; row < plane.length; row++) {
            System.out.print ("   " + (row + 1) + "  ");
            //       add for loop to display one row
            for (char seat : plane[row]) {
                System.out.print (seat + " ");
            }
        //     display row
            System.out.println ();
        }
    }
}