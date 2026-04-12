// class Solution {
//     public int minimumDistance(String word) {
        
//     }
// }
class Solution {
    public int minimumDistance(String word) {
        int[][] dp = new int[26][26];

        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        
        // initial state (free fingers)
        dp[word.charAt(0) - 'A'][26 - 1] = 0;

        for (int i = 1; i < word.length(); i++) {
            int c = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';

            int[][] newDp = new int[26][26];
            for (int[] row : newDp) Arrays.fill(row, Integer.MAX_VALUE);

            for (int f1 = 0; f1 < 26; f1++) {
                for (int f2 = 0; f2 < 26; f2++) {
                    if (dp[f1][f2] == Integer.MAX_VALUE) continue;

                    // move finger1
                    int cost1 = dp[f1][f2] + dist(prev, c);
                    newDp[c][f2] = Math.min(newDp[c][f2], cost1);

                    // move finger2
                    int cost2 = dp[f1][f2] + dist(f2, c);
                    newDp[f1][c] = Math.min(newDp[f1][c], cost2);
                }
            }

            dp = newDp;
        }

        int res = Integer.MAX_VALUE;
        for (int[] row : dp) {
            for (int val : row) {
                res = Math.min(res, val);
            }
        }

        return res;
    }

    private int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}