class Solution {
    // static cnt=0;
    public int ways(int i,int j,int m,int n,int[][] obstacleGrid,int[][] dp){
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(obstacleGrid[i][j]==1){
            return 0;        
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        int left=ways(i+1,j,m,n,obstacleGrid,dp);
        int right=ways(i,j+1,m,n,obstacleGrid,dp);
        dp[i][j]=left+right;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        return ways(0,0,m,n,obstacleGrid,dp);
    }
}