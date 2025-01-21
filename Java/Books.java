import java.io.*;
 
public class Books {
 
    public static void main(String[] args) {
    	
    	//----------------------------------//
    	//  My SamsBookstore.txt file path  //
    	//----------------------------------//
    	
        String filepath = "C:\\Users\\amooo\\Downloads\\CCBC\\CSIT 210\\Java\\SamsBookstore.txt";
        
        //-------------------------------//
        //  Arrays to store books titles //
        //-------------------------------//
        
        String[] bookstitles = new String[7000];
        int[] titlecounts = new int[7000];
        int titleindex = 0;
 
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            
            //-----------------------------------//
            //  The file being read line by line //
            //-----------------------------------//
                                                           //----------------------------------------------------------------------//
            while ((line = reader.readLine()) != null) {   //  To check if the file is already recorded to know if it's duplicated //
                if (!line.isEmpty()) {                     //----------------------------------------------------------------------//
                    int index = findtitle(bookstitles, line, titleindex);
                    if (index == -1) {
                    	bookstitles[titleindex] = line;
                    	titlecounts[titleindex++] = 1;
                    } else {
                    	titlecounts[index]++;
                    }
                }                  //---------------------------------------------//
            }                      //  Solve errors when the files are being read //
        } catch (Exception e) {    //---------------------------------------------//
            System.out.println("Error reading the file " + filepath);
        }
        
        //---------------------------------//
        //  Displays the duplicated titles //
        //---------------------------------//

        printDuplicateBooks(bookstitles, titlecounts, titleindex);    //-------------------------------------------//
    }                                                                 // Function to find the index of the titles  //
                                                                      //-------------------------------------------//
    private static int findtitle(String[] bookstitles, String titles, int titleindex) {
        for (int i = 0; i < titleindex; i++) {
            if (bookstitles[i].equals(titles)) {
                return i;
            }
        }
        return -1;                                                    //---------------------------------------------//
    }                                                                 // Function to Displays the duplicated titles  //
                                                                      //---------------------------------------------//
    private static void printDuplicateBooks(String[] bookstitles, int[] titlecounts, int titleindex) {
        System.out.println("Duplicate Books at Sam's Bookstore 2021:"); // Added this line
        boolean foundDuplicates = false;
        for (int i = 0; i < titleindex; i++) {
            if (titlecounts[i] > 1) {
                System.out.println(bookstitles[i]);
                foundDuplicates = true;
            }                      //--------------------------------//
        }                          //    If no duplication was found //
        if (!foundDuplicates) {    //--------------------------------//
            System.out.println("No duplicates found.");
        }
    }
}