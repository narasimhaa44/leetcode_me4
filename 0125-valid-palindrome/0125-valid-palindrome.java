// class Solution {
//     public boolean isPalindrome(String s) {
//         int[] freq=new int[256];
//         int i=0;
//         String p=s.tolower();
//         for(i=0;i<p.length()/2;i++){
//             if(!(s.charAt(i)>='a' && s.charAt(i)<='z')) continue;
//             freq[p.charAt(i)-'a']++;
//         }
//         for(int j=i+1;j<p.length()-1;j++){
//             if(!(s.charAt(j)>='a' && s.charAt(j)<='z')) continue;
//             freq[p.charAt(i)-'a']--;
//         }
//         for(int k=0;k<256;k++){
//             if(freq[k]!=0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}