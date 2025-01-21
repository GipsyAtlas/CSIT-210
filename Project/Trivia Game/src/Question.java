public class Question {
	
	//-------------------------------------------------------------//
	//  The string of the question, answer and the correct answer  //
	//-------------------------------------------------------------//
	
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private int correctans;

    //-------------------------------------//
    //  Constructor for all the attribute  //
    //-------------------------------------//
    
    public Question(String question, String ans1, String ans2, String ans3, String ans4, int correctans) {
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.correctans = correctans;
    }

    //-------------------------------------------//
    //  Accessor methods to get attribute value  //
    //-------------------------------------------//
    
    public String getquestion() {
        return question;
    }

    public String getans1() {
        return ans1;
    }

    public String getans2() {
        return ans2;
    }

    public String getans3() {
        return ans3;
    }

    public String getans4() {
        return ans4;
    }

    public int getcorrectans() {
        return correctans;
    }

    //--------------------------------------------------//
    //  Mutator methods to update the attribute values  //
    //--------------------------------------------------//
    
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswerOne(String answerOne) {
        this.ans1 = answerOne;
    }

    public void setAnswerTwo(String answerTwo) {
        this.ans2 = answerTwo;
    }

    public void setAnswerThree(String answerThree) {
        this.ans3 = answerThree;
    }

    public void setAnswerFour(String answerFour) {
        this.ans4 = answerFour;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctans = correctAnswer;
    }

    //---------------------------------------------//
    //  Method to monitor for the correct answers  //
    //---------------------------------------------//
    
    public boolean iscorrect(int ans) {
        return ans == correctans;
    }
}