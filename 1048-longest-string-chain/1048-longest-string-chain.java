// class Solution {
//     public int longestStrChain(String[] words) {
        
//     }
// }
import java.util.*;

class Solution {

    public boolean isPredecessor(String s1, String s2){

        if(s2.length() != s1.length() + 1)
            return false;

        int i = 0;
        int j = 0;

        while(j < s2.length()){

            if(i < s1.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }

        return i == s1.length();
    }

    public int longestStrChain(String[] words) {

        int n = words.length;

        Arrays.sort(words,(a,b)->a.length()-b.length());

        int[] dp = new int[n];

        Arrays.fill(dp,1);

        int maxi = 1;

        for(int i=0;i<n;i++){

            for(int j=0;j<i;j++){

                if(isPredecessor(words[j],words[i]) && dp[j]+1>dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }

            maxi = Math.max(maxi,dp[i]);
        }

        return maxi;
    }
}