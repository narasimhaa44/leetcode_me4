// class Solution {
//     public int numTrees(int n) {
//         int[] dp = new int[n + 1];

//         dp[0] = 1;
//         dp[1] = 1;

//         for (int nodes = 2; nodes <= n; nodes++) {
//             for (int root = 1; root <= nodes; root++) {
//                 dp[nodes] += dp[root - 1] * dp[nodes - root];
//             }
//         }

//         return dp[n];
//     }
// }
// class Solution {
//     public int numTrees(int n) {
//         return count(1, n);
//     }

//     private int count(int start, int end) {
//         // empty tree
//         if (start > end) return 1;

//         int total = 0;

//         for (int i = start; i <= end; i++) {
//             int leftCount = count(start, i - 1);
//             int rightCount = count(i + 1, end);

//             total += leftCount * rightCount;
//         }

//         return total;
//     }
// }
class Solution {
    int[][] dp;

    public int numTrees(int n) {
        dp = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(int start, int end) {
        if (start > end) return 1;

        if (dp[start][end] != 0)
            return dp[start][end];

        int total = 0;

        for (int i = start; i <= end; i++) {
            int left = count(start, i - 1);
            int right = count(i + 1, end);
            total += left * right;
        }

        dp[start][end] = total;
        return total;
    }
}
