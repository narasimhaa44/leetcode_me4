import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // If start or end is blocked
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;
        
        // Directions: 8 possible moves
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        // Min-heap: {distance, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{1, 0, 0});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int dist = current[0], r = current[1], c = current[2];

            // Reached bottom-right
            if (r == n - 1 && c == n - 1)
                return dist;

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{dist + 1, nr, nc});
                }
            }
        }

        return -1;
    }
}
