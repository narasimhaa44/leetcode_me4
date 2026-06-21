// import java.util.*;

// class Solution {

//     int[][] dp;

//     public int maxIceCream(int[] costs, int coins) {
//         int n = costs.length;
        
//         // dp[i][c] = max items from index i with c coins
//         dp = new int[n][coins + 1];
        
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
        
//         return solve(0, coins, costs);
//     }

//     private int solve(int i, int coins, int[] costs) {
//         // base case
//         if (i == costs.length) return 0;

//         if (dp[i][coins] != -1) return dp[i][coins];

//         // skip
//         int skip = solve(i + 1, coins, costs);

//         // take
//         int take = 0;
//         if (coins >= costs[i]) {
//             take = 1 + solve(i + 1, coins - costs[i], costs);
//         }

//         return dp[i][coins] = Math.max(take, skip);
//     }
// }
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);  // sort prices
        
        int count = 0;
        
        for (int cost : costs) {
            if (coins >= cost) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }
        
        return count;
    }
}