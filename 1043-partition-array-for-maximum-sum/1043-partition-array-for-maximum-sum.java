// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
        
//     }
// }
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {

            int max = 0;

            for(int j = i; j >= 0 && i - j + 1 <= k; j--) {

                max = Math.max(max, arr[j]);

                int len = i - j + 1;

                int prev = (j > 0) ? dp[j-1] : 0;

                dp[i] = Math.max(dp[i], prev + max * len);
            }
        }

        return dp[n-1];
    }
}