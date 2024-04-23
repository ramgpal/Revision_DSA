import java.util.*;

public class BFS {

    // 1 based indexing
    public static void bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[adj.size() + 1]; 
        q.add(1); 
        visited[1] = true; 

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < adj.get(curr).size(); i++) {
                int next = adj.get(curr).get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int edges[][] = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 4}, {4, 5}};
        int n = 5;
        int m = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) { 
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        bfs(adj);
    }
}
