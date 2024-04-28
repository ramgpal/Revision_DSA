import java.util.*;
public class rottenOrange {
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int freshOranges = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshOranges++; 
                }
            }
        }

        if(freshOranges == 0) {
            return 0;
        }
        
        int maxTime = -1;
        while(!q.isEmpty()) {
            int tmp[] = q.remove();
            int i = tmp[0];
            int j = tmp[1];
            int time = tmp[2];
            maxTime = Math.max(maxTime, time);
            
            // down
            if(i+1 < grid.length) {
                if(grid[i+1][j] == 1 && !vis[i+1][j]) {
                    vis[i+1][j] = true;
                    q.add(new int[]{i+1, j, time+1});
                }
            }
            
            // up
            if(i-1 >= 0) {
                if(grid[i-1][j] == 1 && !vis[i-1][j]) {
                    vis[i-1][j] = true;
                    q.add(new int[]{i-1, j, time+1});
                }
            }
            
            // left
            if(j+1 < grid[0].length) {
                if(grid[i][j+1] == 1 && !vis[i][j+1]) {
                    vis[i][j+1] = true;
                    q.add(new int[]{i, j+1, time+1});
                }
            }
            
            // right
            if(j-1 >= 0) {
                if(grid[i][j-1] == 1 && !vis[i][j-1]) {
                    vis[i][j-1] = true;
                    q.add(new int[]{i, j-1, time+1});
                }
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    return -1; 
                }
            }
        }
        
        return maxTime;
    }
    public static void main(String[] args) {
        // int grid[][] = {{2,1,1},{0,1,1},{1,0,1}};
        int grid[][] = {{0,2}};
        System.out.println(orangesRotting(grid));
    }
}
