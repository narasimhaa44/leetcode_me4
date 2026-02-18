class Solution {
    public int ways(int i,int j,String s,String t,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j]=ways(i-1,j-1,s,t,dp)+ways(i-1,j,s,t,dp);
        }else{
            dp[i][j]=ways(i-1,j,s,t,dp);
        }
        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        long[][] dp=new long[n+1][m+1]; 
        // return ways(n-1,m-1,s,t,dp);
        for(int i=0;i<=n;i++){
                dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return (int)dp[n][m];
    }
}