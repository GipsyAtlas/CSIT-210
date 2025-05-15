public class Employee extends People {
    private double salary;
    private int workingHours;
 
    //----------------------------------//
    //  Constructor for Employee class  //
    //----------------------------------//
 
    public Employee(String firstName, String lastName, String address, double salary, int workingHours) {
        super(firstName, lastName, address);
        this.salary = salary;
        this.workingHours = workingHours;
    }
 
    //-----------------------------------------------//
    //  Method to calculate the employee's paycheck  //
    //-----------------------------------------------//
 
    public double calculatePaycheck() {
        if (workingHours > 165) {
            int overtimeHours = workingHours - 165;
            return salary + (overtimeHours * (salary / 165) * 1.5);
        }
        return salary;
    }
 
    //------------------------------------------//
    //  Getter methods for Employee attributes  //
    //------------------------------------------//
 
    public double getSalary() {
        return salary;
    }
 
    public int getWorkingHours() {
        return workingHours;
    }
 
    //-------------------------------------------//
    //  Overriding toString method for Employee  //
    //-------------------------------------------//
 
    public String toString() {
        return firstName + " " + lastName + " - Paycheck: $" + String.format("%.2f", calculatePaycheck());
    }
}