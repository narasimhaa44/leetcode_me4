import java.util.*;

class Solution {

    static class Pair {
        int to, cost;
        Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node {
        int city, cost, stops;
        Node(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.get(from).add(new Pair(to, price));
        }

        // Step 2: Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: BFS queue — stores (city, cost so far, stops used)
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, 0, 0));

        // Step 4: BFS traversal with stop limit
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int city = curr.city;
            int cost = curr.cost;
            int stops = curr.stops;

            // if we have exceeded the number of stops, skip further
            if (stops > k) continue;

            for (Pair nei : adj.get(city)) {
                int nextCity = nei.to;
                int nextCost = nei.cost;

                // if cheaper route found within allowed stops
                if (cost + nextCost < dist[nextCity] && stops <= k) {
                    dist[nextCity] = cost + nextCost;
                    q.add(new Node(nextCity, dist[nextCity], stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
