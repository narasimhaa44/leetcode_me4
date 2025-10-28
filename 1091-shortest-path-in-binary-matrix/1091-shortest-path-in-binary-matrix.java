import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{1, 0, 0}); // {distance, row, col}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1) return d;

            if (d > dist[r][c]) continue; // outdated entry

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                    int newDist = d + 1;
                    if (newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist;
                        pq.offer(new int[]{newDist, nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}
