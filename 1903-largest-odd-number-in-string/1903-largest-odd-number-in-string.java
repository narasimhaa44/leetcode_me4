class Solution {
    public String largestOddNumber(String num) {
        // Traverse from right to left
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if ((c - '0') % 2 != 0) { // found an odd digit
                return num.substring(0, i + 1);
            }
        }
        return ""; // no odd digit found
    }
}
