// class Solution {
//     public List<Integer> solveQueries(int[] nums, int[] queries) {
//         int n = nums.length;
//         int[] res = new int[n];

//         for (int i = 0; i < n; i++) {
//             int minDist = Integer.MAX_VALUE;

//             for (int j = 0; j < n; j++) {
//                 if (i != j && nums[i] == nums[j]) {
//                     int diff = Math.abs(i - j);
//                     int dist = Math.min(diff, n - diff); // circular
//                     minDist = Math.min(minDist, dist);
//                 }
//             }

//             res[i] = (minDist == Integer.MAX_VALUE) ? -1 : minDist;
//         }

//         List<Integer> ans = new ArrayList<>();
//         for (int q : queries) {
//             ans.add(res[q]);
//         }

//         return ans;
//     }
// }
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: group indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);

        // Step 2: process each group
        for (List<Integer> list : map.values()) {
            int size = list.size();

            if (size == 1) continue; // no duplicate

            for (int i = 0; i < size; i++) {
                int curr = list.get(i);

                int prev = list.get((i - 1 + size) % size);
                int next = list.get((i + 1) % size);

                int d1 = Math.abs(curr - prev);
                int d2 = Math.abs(curr - next);

                int dist1 = Math.min(d1, n - d1);
                int dist2 = Math.min(d2, n - d2);

                res[curr] = Math.min(dist1, dist2);
            }
        }

        // Step 3: answer queries
        List<Integer> ans = new ArrayList<>();
        for (int q : queries) {
            ans.add(res[q]);
        }

        return ans;
    }
}
// 👉 1. Direct path
// |i - start|
// 👉 2. Circular path (wrap around)
// n - |i - start|

// 👉 We take:

// minimum of both