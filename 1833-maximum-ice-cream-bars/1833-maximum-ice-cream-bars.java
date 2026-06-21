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
        int max = 100000;
        int[] freq = new int[max + 1];
        
        // count frequency
        for (int cost : costs) {
            freq[cost]++;
        }
        
        int count = 0;
        
        // try buying from cheapest
        for (int cost = 1; cost <= max; cost++) {
            if (freq[cost] == 0) continue;
            
            int canBuy = Math.min(freq[cost], coins / cost);
            
            count += canBuy;
            coins -= canBuy * cost;
            
            if (coins < cost) break;
        }
        
        return count;
    }
}