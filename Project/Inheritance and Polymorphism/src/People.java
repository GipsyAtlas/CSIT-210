public class People {
    
	//---------------------------------------//
    //  Instance variables for People class  //
    //---------------------------------------//
	
	protected String firstName;
    protected String lastName;
    protected String address;
    
    //--------------------------------//
    //  Constructor for People class  //
    //--------------------------------//
 
    public People(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    
    //--------------------------------//
    //  Getter method for first name  //
    //--------------------------------//
 
    public String getFirstName() {
        return firstName;
    }
    
    //-------------------------------//
    //  Getter method for last name  //
    //-------------------------------//
 
    public String getLastName() {
        return lastName;
    }
}