class Solution {
    public int ways(int i,int j,String s,int[][] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
           dp[i][j]=2+ways(i+1,j-1,s,dp);
        //    System.out.println(dp[i][j]);
        }
        else{
            dp[i][j]=Math.max(ways(i+1,j,s,dp),ways(i,j-1,s,dp));
        }
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
       return  ways(0,n-1,s,dp);
    }
}