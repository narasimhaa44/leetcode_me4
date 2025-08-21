import java.util.*;

class Solution {
    public String reverseWords(String s) {
        // Trim extra spaces at start and end
        s = s.trim();
        
        // Split by spaces (multiple spaces handled with regex)
        String[] arr = s.split("\\s+");

        // Use stack to reverse
        Stack<String> st = new Stack<>();
        for (String word : arr) {
            st.push(word);
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
            if (!st.isEmpty()) {
                res.append(" ");
            }
        }

        return res.toString();
    }
}
