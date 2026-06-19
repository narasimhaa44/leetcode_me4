class Solution {
    public String reverseOnlyLetters(String s) {

        int l = 0;
        int r = s.length() - 1;

        char[] chr = s.toCharArray();

        while(l < r){

            // skip non-letters from left
            if(!Character.isLetter(chr[l])){
                l++;
                continue;
            }

            // skip non-letters from right
            if(!Character.isLetter(chr[r])){
                r--;
                continue;
            }

            // swap letters
            char temp = chr[l];
            chr[l] = chr[r];
            chr[r] = temp;

            l++;
            r--;
        }

        return new String(chr);
    }
}