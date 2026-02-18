class Solution {
    public int ways(int i,int j,String s,String t,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=0) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
           return dp[i][j]=ways(i-1,j-1,s,t,dp);
        }
        int insert=1+ways(i,j-1,s,t,dp);
        int delete=1+ways(i-1,j,s,t,dp);
        int replace=1+ways(i-1,j-1,s,t,dp);
        return dp[i][j] = Math.min(insert, 
                             Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];
        return ways(n-1,m-1,word1,word2,dp);
    }
}