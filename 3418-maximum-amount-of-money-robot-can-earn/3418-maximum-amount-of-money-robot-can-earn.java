// class Solution {
//     public int ways(int i,int j,int[][] coins,int k){
//         int m=coins.length;
//         int n=coins[0].length;
//         if(i<0 || j<0 || i>m-1 || j>n-1) return 0;
//         if(i==m-1 && j==n-1) return coins[i][j];
//         if(coins[i][j]>=0){
//             int take=coins[i][j]+Math.max(ways(i,j+1,coins,k),ways(i+1,j,coins,k));
//             int nottake=Math.max(ways(i,j+1,coins,k),ways(i+1,j,coins,k));
//             return Math.max(take,nottake);
//         }
//         else if(coins[i][j]<0 && k>0){
//             coins[i][j]=0;
//             k--;
//         } 
//     }
//     public int maximumAmount(int[][] coins) {
//         return ways(0,0,coins,2);
//     }
// }
// class Solution {
//     public int ways(int i,int j,int[][] coins,int k,int[][][] dp){
//         int m=coins.length;
//         int n=coins[0].length;

//         if(i>=m || j>=n) return Integer.MIN_VALUE;

//         if(i==m-1 && j==n-1){
//             if(coins[i][j] < 0 && k > 0) return 0;
//             return coins[i][j];
//         }
//         if(dp[i][j][k]!=0) return dp[i][j][k];
//         int right = ways(i,j+1,coins,k,dp);
//         int down = ways(i+1,j,coins,k,dp);

//         int res = Integer.MIN_VALUE;

//         if(coins[i][j] >= 0){
//             dp[i][j][k]= coins[i][j] + Math.max(right, down);
//         }
//         else{
//             int take = coins[i][j] + Math.max(right, down);

//             int skip = Integer.MIN_VALUE;
//             if(k > 0){
//                 skip = Math.max(
//                     ways(i,j+1,coins,k-1,dp),
//                     ways(i+1,j,coins,k-1,dp)
//                 );
//             }

//             dp[i][j][k]= Math.max(take, skip);
//         }

//         return dp[i][j][k];
//     }

//     public int maximumAmount(int[][] coins) {
//         int m=coins.length;
//         int n=coins[0].length;
//         int[][][] dp=new int[m][n][3];
//         // return ways(0,0,coins,2,dp);
//         for(int i=m-1;i>=0;i--){
            
//         }
//     }
// }
class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        for (int k = 0; k <= 2; k++) {
            if (coins[m-1][n-1] < 0 && k > 0) {
                dp[m-1][n-1][k] = 0;
            } else {
                dp[m-1][n-1][k] = coins[m-1][n-1];
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                for (int k = 0; k <= 2; k++) {
                    int right = (j + 1 < n) ? dp[i][j+1][k] : Integer.MIN_VALUE;
                    int down  = (i + 1 < m) ? dp[i+1][j][k] : Integer.MIN_VALUE;
                    int res = Integer.MIN_VALUE;
                    if (coins[i][j] >= 0) {
                        int bestNext = Math.max(right, down);
                        if (bestNext != Integer.MIN_VALUE) {
                            res = coins[i][j] + bestNext;
                        }
                    } else {
                        int take = Integer.MIN_VALUE;
                        int bestNext = Math.max(right, down);
                        if (bestNext != Integer.MIN_VALUE) {
                            take = coins[i][j] + bestNext;
                        }

                        int skip = Integer.MIN_VALUE;
                        if (k > 0) {
                            int rightSkip = (j + 1 < n) ? dp[i][j+1][k-1] : Integer.MIN_VALUE;
                            int downSkip  = (i + 1 < m) ? dp[i+1][j][k-1] : Integer.MIN_VALUE;
                            skip = Math.max(rightSkip, downSkip);
                        }
                        res = Math.max(take, skip);
                    }
                    dp[i][j][k] = res;
                }
            }
        }
        return dp[0][0][2];
    }
}