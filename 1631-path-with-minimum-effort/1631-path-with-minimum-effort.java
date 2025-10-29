import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] effort = new int[n][m];
        for (int[] row : effort)
            Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        // Min-heap: [effort, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int diff = curr[0];
            int r = curr[1];
            int c = curr[2];

            // If we reached destination
            if (r == n - 1 && c == m - 1)
                return diff;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int newEffort = Math.max(diff, Math.abs(heights[r][c] - heights[nr][nc]));
                    if (newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort;
                        pq.add(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }

        return 0; // Should never reach here
    }
}
