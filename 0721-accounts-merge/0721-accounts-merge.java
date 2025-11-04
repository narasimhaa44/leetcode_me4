import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet dsu = new DisjointSet(n);
        Map<String, Integer> emailToAcc = new HashMap<>();

        // Step 1: Union accounts by common email
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToAcc.containsKey(email)) {
                    emailToAcc.put(email, i);
                } else {
                    dsu.unionByRank(i, emailToAcc.get(email));
                }
            }
        }

        // Step 2: Group emails by their ultimate parent
        Map<Integer, Set<String>> merged = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAcc.entrySet()) {
            String email = entry.getKey();
            int parent = dsu.findPar(entry.getValue());
            merged.putIfAbsent(parent, new TreeSet<>());
            merged.get(parent).add(email);
        }

        // Step 3: Build the result list
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : merged.entrySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(entry.getKey()).get(0)); // name
            temp.addAll(entry.getValue());
            res.add(temp);
        }
        return res;
    }
}

// Union-Find (Disjoint Set Union)
class DisjointSet {
    List<Integer> parent, rank;

    DisjointSet(int n) {
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    int findPar(int node) {
        if (node == parent.get(node)) return node;
        int p = findPar(parent.get(node));
        parent.set(node, p); // path compression
        return p;
    }

    void unionByRank(int u, int v) {
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
}
