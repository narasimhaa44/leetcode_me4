class Solution {
    public boolean checkStrings(String s1, String s2) {
    //    char[] ch1=s1.toCharArray();
    //    char[] ch2=s2.toCharArray();
    //    Arrays.sort(ch1);
    //    Arrays.sort(ch2);
    //    if(Arrays.equals(ch1,ch2)){
    //     return true;
    //    } 
    //    return false;
    // int[] freq=new int[26];
    //     for(char ch:ch1){
    //         freq[ch-'a']++;
    //     }
    //     for(char ch:ch2){
    //         freq[ch-'a']--;
    //     }
    //     for(int i=0;i<26;i++){
    //         if(freq[i]!=0){
    //             return false;
    //         }
    //     }
    //     return true;
    int[] even=new int[26];
    int[] odd=new int[26];
    for(int i=0;i<s1.length();i++){
        if(i%2==0){
            even[s1.charAt(i)-'a']++;
            even[s2.charAt(i)-'a']--;
        }else{
            odd[s1.charAt(i)-'a']++;
            odd[s2.charAt(i)-'a']--;
        }
    }
    for(int i=0;i<26;i++){
            if(even[i]!=0 || odd[i]!=0){
                return false;
            }
    }
    return true;
    }
}