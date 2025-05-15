import java.util.Random;

public class BinaryHeap extends BinaryTree {

    //------------------------------------//
    //  Instance variable for swap count  //
    //------------------------------------//

    private int swapCount;

    //------------------------------------//
    //  Constructor for BinaryHeap class  //
    //------------------------------------//

    public BinaryHeap(int capacity) {
        super(capacity);  //  Call superclass constructor to initialize heap
    }

    //------------------------------------------//
    //  Getter method to return the swap count  //
    //------------------------------------------//

    public int getSwapCount() {
        return swapCount;
    }

    //------------------------------------------------------//
    //  Method to add elements to the heap one at a time    //
    //  while counting swaps during insertion (heapify up)  //
    //------------------------------------------------------//

    public void addElementOneAtATime(int[] elements) {
        swapCount = 0;
        for (int element : elements) {
            add(element);
        }
    }

    //-------------------------------------------------//
    //  Private helper method to insert value in heap  //
    //  Maintains min-heap property by bubbling up     //
    //-------------------------------------------------//

    private void add(int value) {
        heap[size] = value;
        int current = size;
        size++;

        while (current > 0) {
            int parent = (current - 1) / 2;

            //  Swap if current value is smaller than parent
            if (heap[current] < heap[parent]) {
                swap(current, parent);
                swapCount++;
                current = parent;
            } else {
                break;  //  Heap property satisfied
            }
        }
    }

    //-------------------------------------------------------------//
    //  Build a heap using a linear time algorithm (heapify down)  //
    //  This method is more efficient than inserting one-by-one    //
    //-------------------------------------------------------------//

    public void buildHeapLinearTime(int[] elements) {
        System.arraycopy(elements, 0, heap, 0, elements.length);
        size = elements.length;
        swapCount = 0;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    //---------------------------------------------//
    //  Heapify function to restore heap property  //
    //  Compares parent with left and right child  //
    //---------------------------------------------//

    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            swapCount++;
            heapify(smallest);
        }
    }

    //---------------------------------//
    //  Swap two elements in the heap  //
    //---------------------------------//

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    //--------------------------------//
    //  Main method for testing heap  //
    //--------------------------------//

    public static void main(String[] args) {
        Random random = new Random();
        int[] elements = new int[20];

        //  Generate 20 random integers between 0 and 500
        for (int i = 0; i < elements.length; i++) {
            elements[i] = random.nextInt(501);
        }

        //  Print the generated random numbers
        System.out.println("20 generated random numbers:");
        for (int num : elements) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        //  The first method for adding one element at a time
        BinaryHeap binaryHeap = new BinaryHeap(elements.length);
        long startTime = System.nanoTime();
        binaryHeap.addElementOneAtATime(elements);
        long endTime = System.nanoTime();

        System.out.println("Heap after adding one element at a time:");
        System.out.println("Pre-Order:");
        binaryHeap.iteratorPreOrder();
        System.out.println("Total swaps of the one at a time method: " + binaryHeap.getSwapCount());
        System.out.println("Execution time of the one at a time method: " + (endTime - startTime) + "ns\n");

        //  The second method for building the heap using linear time algorithm
        binaryHeap = new BinaryHeap(elements.length);
        startTime = System.nanoTime();
        binaryHeap.buildHeapLinearTime(elements);
        endTime = System.nanoTime();

        System.out.println("Heap after building in linear time:");
        System.out.println("Pre-Order:");
        binaryHeap.iteratorPreOrder();
        System.out.println("Total swaps of the linear time method: " + binaryHeap.getSwapCount());
        System.out.println("Execution time of the linear time method: " + (endTime - startTime) + "ns");
    }
}
