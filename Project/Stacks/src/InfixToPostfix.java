public class InfixToPostfix {

    //-----------------------------------//
    //  Check if a token is an operator  //
    //-----------------------------------//
    
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/");
    }

    //---------------------------------//
    //  Determine operator precedence  //
    //---------------------------------//
    
    private static int precedence(String op) {
        if (op.equals("+") || op.equals("-"))
            return 1;
        else if (op.equals("*") || op.equals("/"))
            return 2;
        else
            return 0;
    }

    //-------------------------------------------//
    //  Convert an infix expression into tokens  //
    //-------------------------------------------//

    public static String[] tokenize(String infix) {
        java.util.ArrayList<String> tokens = new java.util.ArrayList<>();
        int i = 0;
        while (i < infix.length()) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    number.append(infix.charAt(i)); //  Collect digits
                    i++;
                }
                tokens.add(number.toString()); //  Add number to tokens
            } else if (c == '(' || c == ')' || c == '+' || c == '-' || c == '*' || c == '/') {
                tokens.add(String.valueOf(c)); //  Add operator or parentheses
                i++;
            } else if (c == ' ') {
                i++;
            } else {
                i++; //  Skip unrecognized characters
            }
        }
        return tokens.toArray(new String[0]);
    }

    //---------------------------------------//
    //  Convert infix expression to postfix  //
    //---------------------------------------//
    
    public static String convert(String infix) {
        String[] tokens = tokenize(infix);
        
        MyStack stack = new MyStack(tokens.length);
        stack.setSuppresserrors(true); //  Disable error messages
        java.util.ArrayList<String> output = new java.util.ArrayList<>();
        
        for (String token : tokens) {
            if (token.matches("\\d+")) { 
                output.add(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                String top;
                while ((top = stack.pop()) != null) {
                    if (top.equals("(")) {
                        break;
                    }
                    output.add(top);
                }
            } else if (isOperator(token)) {
                while (true) {
                    String top = stack.peak();
                    if (top == null || top.equals("(") || !isOperator(top)) {
                        break;
                    }
                    if (precedence(top) >= precedence(token)) {
                        output.add(stack.pop()); //  Add higher precedence operators
                    } else {
                        break;
                    }
                }
                stack.push(token);
            }
        }
        
        while (true) {
            String top = stack.pop();
            if (top == null) {
                break;
            }
            if (!top.equals("(") && !top.equals(")")) {
                output.add(top); //  Append remaining operators
            }
        }
        
        return String.join(" ", output); //  Return the postfix expression
    }
}