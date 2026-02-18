class Solution {

    public boolean solve(int i, int j, String s, String p, Boolean[][] dp){

        if(i < 0 && j < 0) return true;
        if(j < 0) return false;

        if(i < 0){
            for(int k = 0; k <= j; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = solve(i-1, j-1, s, p, dp);
        }

        if(p.charAt(j) == '*'){
            return dp[i][j] = solve(i, j-1, s, p, dp) 
                           || solve(i-1, j, s, p, dp);
        }

        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[n][m];

        return solve(n-1, m-1, s, p, dp);
    }
}
