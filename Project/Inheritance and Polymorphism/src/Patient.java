import java.util.List;

public class Patient extends People {
    private String primaryCareDoctor;

    //-------------------------------------//
    //  Constructor for the Patient class  //
    //-------------------------------------//

    public Patient(String firstName, String lastName, String address, String primaryCareDoctor) {
        super(firstName, lastName, address);
        this.primaryCareDoctor = primaryCareDoctor;
    }

    //-----------------------------------------//
    //  Getter method for Primary Care Doctor  //
    //-----------------------------------------//

    public String getPrimaryCareDoctor() {
        return primaryCareDoctor;
    }

    //--------------------------------------------//
    //  Method to register a visit with a doctor  //
    //--------------------------------------------//

    public void visit(Doctor doctor, List<Doctor> doctorsList) {
        doctor.recordVisit();

        // Automatically register a visit to the Primary Care Doctor
        for (Doctor doc : doctorsList) {
            if (doc.getLastName().equalsIgnoreCase(primaryCareDoctor)) {
                doc.recordVisit();
                break; // Stop searching after finding the doctor
            }
        }
    }

    //------------------------------------------//
    //  Overriding toString method for Patient  //
    //------------------------------------------//

    public String toString() {
        return firstName + " " + lastName + " - Primary Care Doctor: " + primaryCareDoctor;
    }
}
