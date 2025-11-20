class Solution {
    public int ways(int i,int j,List<List<Integer>> triangle,int[][] dp){
        if(i>=triangle.size()){
            return 0;
        }
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        else{
            int left=ways(i+1,j,triangle,dp);
            int right=ways(i+1,j+1,triangle,dp);
            dp[i][j]=triangle.get(i).get(j)+Math.min(left,right);
            return dp[i][j];
        }
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[][] dp=new int[m][m];
        for (int a = 0; a < m; a++) {
            Arrays.fill(dp[a], Integer.MAX_VALUE);
        }
        return ways(0,0,triangle,dp);
    }
}