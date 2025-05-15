import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Clinic {

    public static void main(String[] args) {
    	
    	//-------------------------------------//
        //  Scanner object to read user input  //
        //-------------------------------------//

        Scanner inputScanner = new Scanner(System.in);
        
        //-------------------------------------------------------------------------------------------//
        //  Doctor objects for the three doctors with their name, address, specialty, and visit fee  //
        //-------------------------------------------------------------------------------------------//

        Doctor doctorOne = new Doctor("Barry", "Allan", "123 Main St", 8000, 160, "Pediatrician", 100);
        Doctor doctorTwo = new Doctor("Caitlin", "Snow", "456 Oak St", 8500, 170, "Obstetrician", 120);
        Doctor doctorThree = new Doctor("Cisco", "Ramon", "789 Pine St", 9000, 165, "General Practitioner", 110);
        
        //----------------------------------------------------------------------------------------------//
        //  Employee objects for the two employees with their name, address, hours, and monthly salary  //
        //----------------------------------------------------------------------------------------------//

        Employee employeeOne = new Employee("Iris", "West", "321 Elm St", 4000, 170);
        Employee employeeTwo = new Employee("Herry", "Wells", "654 Maple St", 4200, 160);

        //---------------------------------------//
        //  Create lists for staff and patients  //
        //---------------------------------------//
        
        List<People> clinicStaff = new ArrayList<>();
        List<Doctor> doctorsList = new ArrayList<>();
        clinicStaff.add(doctorOne);
        clinicStaff.add(doctorTwo);
        clinicStaff.add(doctorThree);
        clinicStaff.add(employeeOne);
        clinicStaff.add(employeeTwo);

        doctorsList.add(doctorOne);
        doctorsList.add(doctorTwo);
        doctorsList.add(doctorThree);

        List<Patient> patientList = new ArrayList<>();
        
        //-----------------------------------------------//
        //  Flag to control loop for patient data entry  //
        //-----------------------------------------------//

        boolean continueEnteringPatients = true;
        while (continueEnteringPatients) {
            System.out.println("Is this a new patient (Yes or No)?");
            String isNewPatient = inputScanner.nextLine();
            String patientLastName;

            if (isNewPatient.equalsIgnoreCase("Yes")) {
                
            	//-----------------------------------------//
                //  Get new patient information from user  //
                //-----------------------------------------//
            	
                System.out.println("Please enter the patient's first name: ");
                String firstName = inputScanner.nextLine();
                System.out.println("Please enter the patient's last name: ");
                patientLastName = inputScanner.nextLine();
                System.out.println("Please enter the patient's address: ");
                String address = inputScanner.nextLine();

                //-----------------------------------------------------//
                //  Show available doctors for Primary Care Physician  //
                //-----------------------------------------------------//
                
                System.out.println("Please enter the name of the patient's Primary Care Doctor (Allan, Snow, Ramon):");
                String primaryCareDoctor = inputScanner.nextLine();
                
                //---------------------------------------------------------//
                //  Check if the doctor name is valid using if statements  //
                //---------------------------------------------------------//

                while (true) {
                    if (primaryCareDoctor.equalsIgnoreCase(doctorOne.getLastName()) ||
                        primaryCareDoctor.equalsIgnoreCase(doctorTwo.getLastName()) ||
                        primaryCareDoctor.equalsIgnoreCase(doctorThree.getLastName())) {
                        break;
                    } else {
                        System.out.println("Invalid doctor name. Please enter one of the following (Allan, Snow, Ramon):");
                        primaryCareDoctor = inputScanner.nextLine();
                    }
                }

                //--------------------------------------------------------//
                //  Creating a new Patient object and adding to the list  //
                //--------------------------------------------------------//
                
                patientList.add(new Patient(firstName, patientLastName, address, primaryCareDoctor));
            } else {
                
                System.out.println("Please enter the patient's last name: ");
                patientLastName = inputScanner.nextLine();
                boolean patientFound = false;
                for (Patient p : patientList) {
                    if (p.getLastName().equalsIgnoreCase(patientLastName)) {
                        patientFound = true;
                        break;
                    }
                }
                if (!patientFound) {
                    System.out.println("Patient not found.");
                    continue;
                }
            }

            //---------------------------------------//
            //  Get doctor's name for patient visit  //
            //---------------------------------------//
            
            System.out.println("Please enter the name of the doctor you want to visit (Allan, Snow, Ramon):");
            String selectedDoctorName = inputScanner.nextLine();
            Doctor selectedDoctor = null;
            for (Doctor doc : doctorsList) {
                if (doc.getLastName().equalsIgnoreCase(selectedDoctorName)) {
                    selectedDoctor = doc;
                    break;
                }
            }

            if (selectedDoctor != null) {
                for (Patient patient : patientList) {
                    if (patient.getLastName().equalsIgnoreCase(patientLastName)) {
                        patient.visit(selectedDoctor, doctorsList);
                        break;
                    }
                }
            } else {
                System.out.println("Doctor not found.");
            }

            //---------------------------------//
            //  Ask if user wants to continue  //
            //---------------------------------//
            
            System.out.println("Do you want to continue entering patients? (Yes or No) ");
            String continueOption = inputScanner.nextLine();
            if (continueOption.equalsIgnoreCase("No")) {
                continueEnteringPatients = false;
            }
        }

        //-------------------------//
        //  Display staff details  //
        //-------------------------//
        
        for (People staffMember : clinicStaff) {
            System.out.println("Name: " + staffMember.getFirstName() + " " + staffMember.getLastName());
            if (staffMember instanceof Doctor) {
                Doctor doc = (Doctor) staffMember;
                System.out.println("Role: Doctor");
                System.out.println("Specialty: " + doc.getMedicalSpecialty());
                System.out.println("Consultation fee: " + doc.getConsultationFee());
                System.out.println("Total visits: " + doc.getTotalVisits());
                
                //-------------------------//
                //  Round up the paycheck  //
                //-------------------------//
                
                System.out.println("Paid: " + Math.ceil(doc.calculatePaycheck()) + "\n");
            } else if (staffMember instanceof Employee) {
                Employee emp = (Employee) staffMember;
                System.out.println("Role: Employee");
                System.out.println("Salary: " + emp.getSalary());
                System.out.println("Hours worked: " + emp.getWorkingHours());
                System.out.println("Paid: " + Math.ceil(emp.calculatePaycheck()) + "\n");
            }
        }

        inputScanner.close();
    }
}
