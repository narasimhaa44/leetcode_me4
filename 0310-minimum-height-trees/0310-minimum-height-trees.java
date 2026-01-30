import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) return Arrays.asList(0);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] degree = new int[n];

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.add(i);
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            ans.clear();

            for (int i = 0; i < size; i++) {
                int node = q.poll();
                ans.add(node);

                for (int nb : adj.get(node)) {
                    degree[nb]--;
                    if (degree[nb] == 1) {
                        q.add(nb);
                    }
                }
            }
        }

        return ans;
    }
}
