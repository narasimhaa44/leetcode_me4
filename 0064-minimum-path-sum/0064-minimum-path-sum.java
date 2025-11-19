// class Solution {
//     // public int ways(int i,int j,int m,int n,int[][] grid,int[][] dp){

//     //     if(i==m-1 && j==n-1){
//     //         return grid[i][j];
//     //     }
//     //     if (i >= m || j >= n) return Integer.MAX_VALUE;
//     //     if(dp[i][j]!=0){
//     //         return dp[i][j];
//     //     }
//     //     int left=ways(i,j+1,m,n,grid,dp);
//     //     int right=ways(i+1,j,m,n,grid,dp);
//     //     return grid[i][j]+Math.min(left,right);
//     // }
//     // return ways(0,0,m,n,grid,dp);    
//     public int minPathSum(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;
//         int[][] dp=new int[m][n];
//         int dp[0][0]=1;
//         for(int i=0;i<m-1;i++){
//             for(int j=0;j<n-1;j++){
//                 if(i>0) left=dp[i-1][j];
//                 if(j>0) right=dp[i][j-1];
//                 dp[i][j]=
//             }
//         }
//     }
// }
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // Fill first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        // Fill first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        // Fill the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
