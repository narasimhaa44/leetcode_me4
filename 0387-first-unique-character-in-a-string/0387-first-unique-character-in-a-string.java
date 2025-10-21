class Solution {
    public int firstUniqChar(String s) {
        int[] freq=new int[26];
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (Character.isLetter(c)) { // check if it's a letter
                c = Character.toLowerCase(c); // make lowercase
                freq[c - 'a']++; // map 'a' -> 0, 'b' -> 1, etc.
            }
        }
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i) - 'a']==1){
                return i;
            }
        }
        return -1;
    }
}