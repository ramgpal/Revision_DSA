import java.util.*;

public class detectCycleDirectedGraph {
    // Function to detect cycle in a directed graph.
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V+1];
        boolean recursiveStack[] = new boolean[V+1];
        for (int i = 0; i <= V; i++) {
            if (!vis[i]) {
                if (isCyclicUtil(adj, vis, recursiveStack, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> edges, boolean vis[], boolean recursiveStack[], int curr) {
        vis[curr] = true;
        recursiveStack[curr] = true;
        for (int next : edges.get(curr)) {
            if (recursiveStack[next]) { // cycle exists
                return true;
            } else if (!vis[next] && isCyclicUtil(edges, vis, recursiveStack, next)) {
                return true;
            }
        }

        recursiveStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int edges[][] = {{1, 2}, {2, 3}, {1, 3}};
        int n = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            adj.get(src).add(dest);
        }

        System.out.println(isCyclic(n, adj));
    }
}
