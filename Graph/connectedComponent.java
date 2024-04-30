import java.util.*;
class connectedComponent {
    public static int countConnectedComponents(int n, ArrayList<ArrayList<Integer>> adj) {
        int count = 0;
        boolean vis[] = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            if(!vis[i]) {
                dfs(vis, i, adj);
                count++;
            }
        }

        return count;
    }

    public static void dfs(boolean vis[], int curr, ArrayList<ArrayList<Integer>> adj) {
        vis[curr] = true;
        for(int i = 0; i < adj.get(curr).size(); i++) {
            int next = adj.get(curr).get(i);
            if(!vis[next]) {
                dfs(vis, next, adj);
            }
        }
    }
    public static void main(String args[] ) throws Exception {
        int graph[][] = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 4}, {4, 5}};
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < graph.length; i++) {
            int src = graph[i][0];
            int dest = graph[i][1];
            adj.get(src).add(dest);
            adj.get(dest).add(src); 
        }
        System.out.println(countConnectedComponents(n, adj));
    }
}
