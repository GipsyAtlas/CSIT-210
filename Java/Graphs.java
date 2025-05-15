import java.util.*;

//-------------------------------------------------//
//  Graphs class to represent an undirected graph  //
//-------------------------------------------------//

public class Graphs {

    //---------------------------------//
    //  Instance variables for Graphs  //
    //---------------------------------//

    private int numVertices;  //  Number of vertices nodes in the graph
    private List<List<Integer>> adjList;  //  Adjacency list to store edges

    //----------------------------------------//
    //  Constructor to initialize the Graphs  //
    //----------------------------------------//

    public Graphs(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());  //  Create a list for each vertex
        }
    }

    //---------------------------------------------------------//
    //  Method to add an undirected edge between two vertices  //
    //---------------------------------------------------------//

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);  //  Add v to u's adjacency list
        adjList.get(v).add(u);  //  Add u to v's adjacency list
    }

    //-----------------------------------//
    //  Method to perform BFS traversal  //
    //-----------------------------------//

    public void bfs(int start) {
        boolean[] visited = new boolean[numVertices];  //  Track visited nodes
        Queue<Integer> queue = new LinkedList<>();  //  Queue for BFS

        visited[start] = true;  //  Mark start node as visited
        queue.offer(start);  //  Enqueue the start node

        System.out.println("BFS Traversal Order:");
        while (!queue.isEmpty()) {
            int current = queue.poll();  //  Dequeue a vertex
            System.out.print(current + " ");  //  Print the vertex

            for (int neighbor : adjList.get(current)) {  //  Visit all adjacent vertices
                if (!visited[neighbor]) {
                    visited[neighbor] = true;  //  Mark neighbor as visited
                    queue.offer(neighbor);  //  Enqueue the neighbor
                }
            }
        }
    }

    //----------------------------------------//
    //  Method to display the adjacency list  //
    //----------------------------------------//

    public void display() {
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    //-------------------------------------//
    //  Main method to interact with user  //
    //-------------------------------------//

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes you want (can't go below 8): ");
        int numNodes = scanner.nextInt();
        if (numNodes < 8) {
            System.out.println("Don't enter a number below 8.");
            scanner.close();
            return;
        }

        Graphs graph = new Graphs(numNodes);

        System.out.print("Enter the number of edges you want: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter each edge as two space separated node indices (Example: '0 1'):");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            if (u >= 0 && u < numNodes && v >= 0 && v < numNodes) {
                graph.addEdge(u, v);  //  Add the valid edge
            } else {
                System.out.println("Invalid edge (" + u + ", " + v + "). Nodes should be between 0 and " + (numNodes - 1) + ".");
                i--;  //  Decrement i to retry this edge input
            }
        }

        graph.display();  //  Show the adjacency list

        System.out.print("\nEnter the starting node for BFS traversal: ");
        int startNode = scanner.nextInt();
        if (startNode >= 0 && startNode < numNodes) {
            graph.bfs(startNode);  //  Perform BFS from the start node
        } else {
            System.out.println("Invalid starting node. Please enter a value between 0 and " + (numNodes - 1) + ".");
        }

        scanner.close();
    }
}
