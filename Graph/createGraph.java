import java.util.*;
public class createGraph {
    public static void main(String[] args) {
        int graph[][] = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 4}, {4, 5}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < graph.length; i++) {
            int src = graph[i][0];
            int dest = graph[i][1];
            adj.get(src).add(dest);
            adj.get(dest).add(src); 
        }

          // Print adjacency list
          for (int i = 1; i < adj.size(); i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}