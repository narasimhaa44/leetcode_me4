class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findPar(int node) {
        if (node == parent.get(node)) return node;
        int p = findPar(parent.get(node));
        parent.set(node, p);  // path compression
        return p;
    }

    public void unionByRank(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if (pu == pv) return;
        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if (pu == pv) return;
        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        // find maximum row and column index
        for (int[] s : stones) {
            maxRow = Math.max(maxRow, s[0]);
            maxCol = Math.max(maxCol, s[1]);
        }

        // create DSU for all possible rows + cols
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();

        // connect row -> col (shift col by maxRow + 1 to make them unique)
        for (int[] s : stones) {
            int nodeRow = s[0];
            int nodeCol = s[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        // count unique parent nodes for all active nodes
        int components = 0;
        for (int node : stoneNodes.keySet()) {
            if (ds.findPar(node) == node)
                components++;
        }

        // total stones - connected components
        return stones.length - components;
    }
}
