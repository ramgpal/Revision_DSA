import java.util.*;
public class detectCycle {
    public static String cycleDetection( int n, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[n+1];
        for(int i = 0; i <= n; i++) {
            if(!vis[i]) {
                if(detectCycleUtil(n, adj, vis, i, -1).equals("Yes")) {
                    return "Yes";
                }
            }
        }

        return "No";

    }

    public static String detectCycleUtil(int n, ArrayList<ArrayList<Integer>> adj, boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            int next = adj.get(curr).get(i);
            if (!vis[next]) {
                if (detectCycleUtil(n, adj, vis, next, curr).equals("Yes")) {
                    return "Yes";
                }
            } else if (next != par) {
                return "Yes";
            }
        }

        return "No";
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
            adj.get(dest).add(src);
        }

        System.out.println(cycleDetection(n, adj));
    }
}
