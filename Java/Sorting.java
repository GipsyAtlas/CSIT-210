import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] sizes = {20, 100, 500, 1000}; // Array sizes to be tested

        while (true) {
            //------------------------------------//
        	//  Display menu options to the user  //
        	//------------------------------------//
            System.out.println("\nSelect a sorting algorithm:");
            System.out.println("1. Selection Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Quick Sort");
            System.out.println("5. Radix Sort");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 6) { // Exit condition
                System.out.println("Exiting program.");
                break;
            }

            //--------------------------------//
            //  Iterate over each array size  //
            //--------------------------------//
            for (int size : sizes) {
                int[] array = new int[size];
                for (int i = 0; i < size; i++) { // Populate the array with random integers
                    array[i] = random.nextInt(1000); //  Random number between 0 and 999
                }

                System.out.println("\nArray size: " + size);
                long startTime = System.nanoTime(); //  Record start time
                switch (choice) {
                    case 1:
                        selectionSort(array.clone());
                        System.out.println("Selection Sort completed.");
                        break;
                    case 2:
                        insertionSort(array.clone());
                        System.out.println("Insertion Sort completed.");
                        break;
                    case 3:
                        bubbleSort(array.clone());
                        System.out.println("Bubble Sort completed.");
                        break;
                    case 4:
                        quickSort(array.clone(), 0, array.length - 1);
                        System.out.println("Quick Sort completed.");
                        break;
                    case 5:
                        radixSort(array.clone());
                        System.out.println("Radix Sort completed.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                long endTime = System.nanoTime(); //  Record end time
                System.out.println("Sorting time: " + (endTime - startTime) / 1e6 + " ms"); //  Calculate and display the sorting duration in milliseconds
            }
        }

        scanner.close();
    }

    //------------------------------------------------------------------------------------------//
    //  Selection Sort: Repeatedly selects the minimum element and places it at the beginning.  //
    //  Time Complexity: O(n^2)                                                                 //
    //------------------------------------------------------------------------------------------//
    
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    //--------------------------------------------------------------------------------------------------------------------//
    //  Insertion Sort: Builds the sorted array one element at a time by inserting elements into their correct position.  //
    //  Time Complexity: O(n^2), but O(n) when nearly sorted.                                                             //
    //--------------------------------------------------------------------------------------------------------------------//
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    //------------------------------------------------------------------------------------//
    //   Bubble Sort: Repeatedly swaps adjacent elements if they are in the wrong order.  //
    //   Time Complexity: O(n^2)                                                          //
    //------------------------------------------------------------------------------------//
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //-----------------------------------------------------------------------------------------------//
    //   Quick Sort: Divides the array into partitions based on a pivot and recursively sorts them.  //
    //   Time Complexity: O(n log n) on average, O(n^2) in the worst case.                           //
    //-----------------------------------------------------------------------------------------------//
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    //----------------------------------------------------------------------------------//
    // Radix Sort: Sorts numbers by processing individual digits.                       //
    // Time Complexity: O(d*(n+b)), where d is the number of digits and b is the base.  //
    //----------------------------------------------------------------------------------//
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}
