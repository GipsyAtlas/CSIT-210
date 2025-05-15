public class Doctor extends Employee {

    //---------------------------------------//
	//  Instance variables for Doctor class  //
	//---------------------------------------//
	
    private String medicalSpecialty;
    private double consultationFee;
    private int totalVisits;

    //------------------------------------//
    //  Constructor for the Doctor class  //
    //------------------------------------//

    public Doctor(String firstName, String lastName, String address, double salary, int workingHours,
                  String medicalSpecialty, double consultationFee) {
        super(firstName, lastName, address, salary, workingHours);
        this.medicalSpecialty = medicalSpecialty;
        this.consultationFee = consultationFee;
        this.totalVisits = 0;
    }

    //--------------------------------------//
    //  Method to record a patient's visit  //
    //--------------------------------------//

    public void recordVisit() {
        totalVisits++; // Increment total visits by 1 for each patient visit
    }

    //---------------------------------------//
    //  Getter method for Medical Specialty  //
    //---------------------------------------//

    public String getMedicalSpecialty() {
        return medicalSpecialty;
    }

    //--------------------------------------//
    //  Getter method for Consultation Fee  //
    //--------------------------------------//

    public double getConsultationFee() {
        return consultationFee;
    }

    //----------------------------------//
    //  Getter method for Total Visits  //
    //----------------------------------//

    public int getTotalVisits() {
        return totalVisits;
    }

    //---------------------------------------//
    //  Only calculate earnings from visits  //
    //---------------------------------------//

    public double calculatePaycheck() {
        return totalVisits * consultationFee;
    }

    //-----------------------------------------//
    //  Overriding toString method for Doctor  //
    //-----------------------------------------//

    public String toString() {
        return "Dr. " + lastName + " - Role: Doctor, Specialty: " + medicalSpecialty + ", Consultation Fee: $"
                + consultationFee + ", Visits: " + totalVisits + ", Paid: $"
                + String.format("%.2f", calculatePaycheck());
    }
}
