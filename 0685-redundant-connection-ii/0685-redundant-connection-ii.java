// class DSU {
//     int[] parent;
//     int[] size;

//     public DSU(int n) {
//         parent = new int[n + 1];
//         size = new int[n + 1];
//         for (int i = 0; i <= n; i++) {
//             parent[i] = i;
//             size[i] = 1;
//         }
//     }

//     public int find(int u) {
//         if (parent[u] != u) {
//             parent[u] = find(parent[u]);
//         }
//         return parent[u];
//     }

//     public boolean UnionBySize(int u, int v) {
//         int pu = find(u);
//         int pv = find(v);
//         if (pu == pv)
//             return true;
//         if (size[pu] >= size[pv]) {
//             parent[pv] = pu;
//             size[pu] += size[pv];
//         } else if (size[pv] > size[pu]) {
//             parent[pu] = pv;
//             size[pv] += size[pu];
//         }
//         return false;
//     }

// }

// class Solution {
//     public int[] findRedundantDirectedConnection(int[][] edges) {
//         DSU ds = new DSU(edges.length);
//         for (int[] edge : edges) {
//             int u = edge[0];
//             int v = edge[1];
//             if (ds.UnionBySize(u, v)) {
//                 return edge;
//             }
//         }
//         return new int[0];
//     }
// }
class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return true;

        if (size[pu] >= size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }

        return false;
    }
}

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;
        int[] parent = new int[n + 1];

        int[] candidate1 = null;
        int[] candidate2 = null;
        int skipIndex = -1;

        // Step 1: Detect two parents
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                candidate1 = new int[]{parent[v], v};
                candidate2 = new int[]{u, v};
                skipIndex = i;  // mark edge to skip
            }
        }

        // Step 2: Union Find
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {

            if (i == skipIndex) continue;

            int u = edges[i][0];
            int v = edges[i][1];

            if (dsu.union(u, v)) {
                if (candidate1 == null) {
                    return edges[i];
                }
                return candidate1;
            }
        }

        return candidate2;
    }
}