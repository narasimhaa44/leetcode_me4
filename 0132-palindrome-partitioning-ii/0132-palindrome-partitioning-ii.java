// class Solution {
//     public int minCut(String s) {
        
//     }
// }
class Solution {
    public int minCut(String s) {

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        // Precompute palindrome table
        for(int end = 0; end < n; end++) {
            for(int start = 0; start <= end; start++) {

                if(s.charAt(start) == s.charAt(end) &&
                   (end - start <= 2 || pal[start+1][end-1])) {

                    pal[start][end] = true;
                }
            }
        }

        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {

            if(pal[0][i]) {
                dp[i] = 0;
            }
            else {

                dp[i] = Integer.MAX_VALUE;

                for(int j = 0; j < i; j++) {

                    if(pal[j+1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n-1];
    }
}