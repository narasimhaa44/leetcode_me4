class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        if(n==0) return 0;
        for(int i=0;i<=m-n;i++){
            int j=0;
            while(j<n && needle.charAt(j)==haystack.charAt(i+j) ){
                j++;
            }
            if(j==n){
                return i;
            }
        }
        return -1;
    }
}