public class PostfixEvaluator {

    //-----------------------------------------//
    //  Method to evaluate postfix expression  //
    //-----------------------------------------//

    public static int evaluate(String postfix) {
        String[] tokens = postfix.split("\\s+");
        MyStack stack = new MyStack(tokens.length);
        stack.setSuppresserrors(true);
        
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(token);
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                if (operand1 == null || operand2 == null) {
                    System.out.println("Error in evaluation.");
                    return 0;
                }
                int op1 = Integer.parseInt(operand1);
                int op2 = Integer.parseInt(operand2);
                int result = 0;
                switch (token) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                    case "/":
                        result = op1 / op2; 
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        
        String finalResult = stack.pop();
        return finalResult != null ? Integer.parseInt(finalResult) : 0;
    }
}