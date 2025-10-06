import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][n];

        // Min-heap based on elevation
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int time = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int t = curr[0], r = curr[1], c = curr[2];
            time = Math.max(time, t); // update max elevation along path

            if(r == n-1 && c == n-1) return time;

            for(int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }
        return -1; // should not happen
    }
}
