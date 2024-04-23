import java.util.*;

public class DFS {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean visited[]) {
        System.out.print(curr+" ");
        visited[curr] = true;
        for(int i = 0; i < adj.get(curr).size(); i++) {
            int next = adj.get(curr).get(i);
            if(!visited[next]) {
                dfs(adj, next, visited);
            }
        }
    }
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

        boolean visited[] = new boolean[adj.size()];
        dfs(adj, 1, visited);
    }
}
