public class MyStack {

    //----------------------------------//
    //  Instance variables for MyStack  //
    //----------------------------------//
    
    private String[] inistar;
    private int start;
    private int amount;
    private int capacity;
    private boolean suppresserrors = false;

    //-------------------------------------//
    //  Constructor for the MyStack class  //
    //-------------------------------------//

    public MyStack(int capacity) {
        this.capacity = capacity;
        inistar = new String[capacity]; //  Create an array for the stack
        start = 0;  //  Initial index position
        amount = 0;   //  Track number of elements in stack
    }

    //----------------------------------------------//
    //  Setter to enable or disable error messages  //
    //----------------------------------------------//
    
    public void setSuppresserrors(boolean suppress) {
        this.suppresserrors = suppress;
    }

    //-------------------------------//
    //  Push method to add elements  //
    //-------------------------------//

    public void push(String s) {
        if (amount < capacity) {
            int pos = (start + amount) % capacity;
            inistar[pos] = s; //  Insert element
            amount++;
        } else {
        	inistar[start] = s; //  Overwrite oldest element when stack is full
            start = (start + 1) % capacity; //  Update start position
        }
    }

    //------------------------------------//
    //  Pop method to remove top element  //
    //------------------------------------//

    public String pop() {
        if (amount == 0) {
            if (!suppresserrors)
                System.out.println("Stack is empty.");
            return null;
        }
        int pos = (start + amount - 1) % capacity;
        String topElement = inistar[pos]; //  Retrieve top element
        inistar[pos] = null; //  Remove element
        amount--; //  Decrease stack size
        return topElement;
    }

    //------------------------------//
    //  Method to view top element  //
    //------------------------------//

    public String peak() {
        if (amount == 0) {
            if (!suppresserrors)
                System.out.println("Stack is empty.");
            return null;
        }
        int pos = (start + amount - 1) % capacity;
        return inistar[pos]; //  Return top element without removal
    }

    //------------------------------------//
    //  Method to display stack contents  //
    //------------------------------------//

    public void display() {
        if (amount == 0) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Elements in the stack: [");
        for (int i = 0; i < amount; i++) {
            int index = (start + i) % capacity;
            System.out.print(inistar[index] + " "); //  Display elements
        }
        System.out.println("]");
    }
}