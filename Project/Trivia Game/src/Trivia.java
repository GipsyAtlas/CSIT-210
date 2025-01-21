import java.util.Scanner;

public class Trivia {
    public static void main(String[] args) {
        
    	//--------------------------------------------------//
    	//  Questions, answers and number for right answer  //
    	//--------------------------------------------------//
    	
        Question[] questions = {    //Questions for player 1
            new Question("What is the largest planet in our solar system?", "Earth", "Mars", "Jupiter", "Saturn", 3),
            new Question("Which country is home to the kangaroo?", "Canada", "Australia", "South Africa", "Brazil", 2),
            new Question("What is the chemical symbol for water?", "O2", "CO2", "H2O", "NaCl", 3),
            new Question("Who was the first president of the United States?", "George Washington", "Abraham Lincoln", "Thomas Jefferson", "John Adams", 1),
            new Question("What is the square root of 64?", "6", "8", "10", "12", 2),
                                    //Questions for player 2
            new Question("What is the capital of Japan?", "Tokyo", "Seoul", "Beijing", "Bangkok", 1),
            new Question("Which element has the atomic number 1?", "Hydrogen", "Helium", "Carbon", "Oxygen", 1),
            new Question("What is the fastest land animal?", "Cheetah", "Lion", "Horse", "Greyhound", 1),
            new Question("Who painted the ceiling of the Sistine Chapel?", "Michelangelo", "Leonardo da Vinci", "Raphael", "Donatello", 1),
            new Question("How many continents are there on Earth?", "5", "6", "7", "8", 3)
        };

        //--------------------------//
        //  Scores for the players  //
        //--------------------------//
        
        int player1score = 0;
        int player2score = 0;

        Scanner scan = new Scanner(System.in);

        //-------------------------------------//
        // Loop of the questions for Player 1  //
        //-------------------------------------//
        
        System.out.println("Question's for player 1:");
        for (int i = 0; i < 5; i++) {
            System.out.println(questions[i].getquestion());
            System.out.println("1. " + questions[i].getans1());
            System.out.println("2. " + questions[i].getans2());
            System.out.println("3. " + questions[i].getans3());
            System.out.println("4. " + questions[i].getans4());
            System.out.print("What is your answer: ");
            int ans = scan.nextInt();

            if (questions[i].iscorrect(ans)) {
                System.out.println("You got it correct.");
                player1score++;
            } else {
                System.out.println("You got the answer wrong.");
            }
        }

        //-------------------------------------//
        // Loop of the questions for Player 2  //
        //-------------------------------------//
        
        System.out.println("Question's for player 2:");
        for (int i = 5; i < 10; i++) {
            System.out.println(questions[i].getquestion());
            System.out.println("1. " + questions[i].getans1());
            System.out.println("2. " + questions[i].getans2());
            System.out.println("3. " + questions[i].getans3());
            System.out.println("4. " + questions[i].getans4());
            System.out.print("What is your answer: ");
            int ans = scan.nextInt();

            if (questions[i].iscorrect(ans)) {
                System.out.println("You got it correct.");
                player2score++;
            } else {
                System.out.println("You got the answer wrong.");
            }
        }

        //-----------------------------------------------//
        //  Display message of the score and the winner  //
        //-----------------------------------------------//
        
        System.out.println("\nScores:");
        System.out.println("Player 1 has " + player1score + " points");
        System.out.println("Player 2 has " + player2score + " points");

        if (player1score > player2score) {
            System.out.println("The winner is player 1.");
        } else if (player2score > player1score) {
            System.out.println("The winner is player 2.");
        } else {
            System.out.println("The game is a tie.");
        }

        scan.close();
    }
}