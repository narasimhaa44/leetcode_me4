// class Solution {
//         public int lcs(int i,int j,String s1,String s2,int[][] dp){
//         if(i<0 || j<0) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(s1.charAt(i)==s2.charAt(j)){
//             return dp[i][j] = 1 + lcs(i-1,j-1,s1,s2,dp);
//         }
//         else{
//             return dp[i][j] = Math.max(
//                 lcs(i-1,j,s1,s2,dp),
//                 lcs(i,j-1,s1,s2,dp)
//             );
//         }
//     }
//     public String shortestCommonSupersequence(String str1, String str2) {
//         int n = str1.length();
//         int m = str2.length();
//         int[][] dp = new int[n][m];
//         for(int[] row : dp)
//             Arrays.fill(row,-1);
//         int lcs = lcs(n-1,m-1,str1,str2,dp);
//         // return n + m - lcs;
//         String ans="";
//         int i=n;
//         int j=m;
//         while(i>0 && j>0){
//             if(str1.charAt(i-1)==str2.charAt(j-1)){
//                 ans+=str1.charAt(i-1);
//                 i--;
//                 j--;
//             }
//             else if(dp[i-1][j]>dp[i][j-1]){
//                 ans+=str1.charAt(i-1);
//                 i--;
//             }
//             else{
//                 ans+=str2.charAt(j-1);
//                 j--;
//             }
//         }
//         while(i>0){
//             ans+=str1.charAt(i-1);
//             i--;
//         } 
//         while(j>0){
//             ans+=str2.charAt(j-1);
//             j--;
//         }
//         return ans;
//     }
// }
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        // Build LCS table (bottom-up)
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Reconstruct SCS
        int i = n;
        int j = m;
        StringBuilder ans = new StringBuilder();

        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                ans.append(str1.charAt(i-1));
                i--;
            }
            else{
                ans.append(str2.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }

        return ans.reverse().toString();
    }
}
