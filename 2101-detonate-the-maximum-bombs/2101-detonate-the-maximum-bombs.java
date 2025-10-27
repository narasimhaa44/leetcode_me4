class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();

        // Build adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long dx = x1 - x2;
                long dy = y1 - y2;
                if (dx * dx + dy * dy <= r1 * r1) {
                    graph.get(i).add(j);
                }
            }
        }

        // Helper DFS function
        boolean[] visited;
        int result = 0;

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            int count = dfs(i, graph, visited);
            result = Math.max(result, count);
        }

        return result;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1; // current bomb
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                count += dfs(nei, graph, visited);
            }
        }
        return count;
    }
}