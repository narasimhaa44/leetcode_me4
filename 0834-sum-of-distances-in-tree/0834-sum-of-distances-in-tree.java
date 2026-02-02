import java.util.*;

class Solution {
    int[] res;
    int[] count;
    List<List<Integer>> tree;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        res = new int[n];
        count = new int[n];
        tree = new ArrayList<>();

        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());

        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        dfs1(0, -1);
        dfs2(0, -1);

        return res;
    }

    void dfs1(int node, int parent) {
        count[node] = 1;
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            dfs1(child, node);
            count[node] += count[child];
            res[node] += res[child] + count[child];
        }
    }

    void dfs2(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            res[child] = res[node] - count[child] + (n - count[child]);
            dfs2(child, node);
        }
    }
}
