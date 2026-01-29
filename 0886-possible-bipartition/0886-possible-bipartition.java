import java.util.*;

class Pair {
    int node;
    int color;
    public Pair(int _node, int _color) {
        this.node = _node;
        this.color = _color;
    }
}

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        Queue<Pair> q = new LinkedList<>();
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                q.add(new Pair(i, 0));
                color[i] = 0;

                while (!q.isEmpty()) {
                    Pair pair = q.poll();
                    int node = pair.node;

                    for (int adjnode : adj.get(node)) {
                        if (color[adjnode] == -1) {
                            color[adjnode] = 1 - color[node];
                            q.add(new Pair(adjnode, color[adjnode]));
                        } else if (color[adjnode] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
