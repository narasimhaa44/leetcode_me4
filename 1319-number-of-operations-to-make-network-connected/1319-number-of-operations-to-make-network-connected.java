class Solution {
    int[] parent;
    
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int extra = 0; // count of redundant edges
        for (int[] c : connections) {
            int a = find(c[0]);
            int b = find(c[1]);
            if (a == b) {
                extra++; // loop formed → extra edge
            } else {
                parent[a] = b;
            }
        }

        // count components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) components++;
        }

        // need (components - 1) edges to connect all
        if (extra >= components - 1) return components - 1;
        return -1;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}
