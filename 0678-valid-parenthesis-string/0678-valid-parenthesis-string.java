class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible '(' count
        int maxOpen = 0; // Maximum possible '(' count

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                // '*' can be '(', ')' or empty
                minOpen--; // if '*' is treated as ')'
                maxOpen++; // if '*' is treated as '('
            }

            // If maxOpen < 0 => too many ')'
            if (maxOpen < 0) return false;

            // minOpen can't be negative
            if (minOpen < 0) minOpen = 0;
        }

        // If minOpen == 0 => valid
        return minOpen == 0;
    }
}
