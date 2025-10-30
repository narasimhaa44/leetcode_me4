import java.util.*;

class Pair {
    int node;
    long time;
    public Pair(int node, long time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // Build adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            adj.get(u).add(new Pair(v, t));
            adj.get(v).add(new Pair(u, t));
        }

        // Distance and ways arrays
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];
        dist[0] = 0;
        ways[0] = 1;

        // Min-heap for Dijkstra
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            long time = curr.time;

            for (Pair next : adj.get(node)) {
                int neighbor = next.node;
                long newTime = time + next.time;

                // Found shorter path
                if (newTime < dist[neighbor]) {
                    dist[neighbor] = newTime;
                    ways[neighbor] = ways[node];
                    pq.add(new Pair(neighbor, newTime));
                }
                // Found another shortest path
                else if (newTime == dist[neighbor]) {
                    ways[neighbor] = (int)((ways[neighbor] + (long)ways[node]) % MOD);
                }
            }
        }

        return ways[n - 1];
    }
}
