// class Solution {
//     public int longestSubstring(String s, int k) {
        
//     }
// }
class Solution {
    public int longestSubstring(String s, int k) {

        int maxLen = 0;

        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {

            int[] freq = new int[26];
            int left = 0, right = 0;

            int unique = 0;       // total unique chars
            int countAtLeastK = 0; // chars with freq ≥ k

            while (right < s.length()) {

                // expand window
                if (freq[s.charAt(right) - 'a'] == 0) {
                    unique++;
                }

                freq[s.charAt(right) - 'a']++;

                if (freq[s.charAt(right) - 'a'] == k) {
                    countAtLeastK++;
                }

                right++;

                // shrink window if too many unique chars
                while (unique > uniqueTarget) {

                    if (freq[s.charAt(left) - 'a'] == k) {
                        countAtLeastK--;
                    }

                    freq[s.charAt(left) - 'a']--;

                    if (freq[s.charAt(left) - 'a'] == 0) {
                        unique--;
                    }

                    left++;
                }

                // valid window
                if (unique == uniqueTarget && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }

        return maxLen;
    }
}