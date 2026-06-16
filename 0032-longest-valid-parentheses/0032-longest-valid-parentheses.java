import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1); // base

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();

                if (st.isEmpty()) {
                    st.push(i); // reset base
                } else {
                    int len = i - st.peek();
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
}