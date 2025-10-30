class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Step 1: Initialize distance matrix
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 100000000); // infinity
            dist[i][i] = 0;
        }

        // Step 2: Fill in edge distances (since bidirectional)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // Step 3: Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 4: Count reachable cities for each city
        int minReachable = Integer.MAX_VALUE;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // If equal, choose greater index
            if (count <= minReachable) {
                minReachable = count;
                city = i;
            }
        }

        return city;
    }
}
