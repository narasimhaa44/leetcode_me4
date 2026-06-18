class Solution {
    int i = 0;

    public int calculate(String s) {
        return helper(s);
    }

    private int helper(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // 🔥 handle parentheses
            if (c == '(') {
                i++;
                num = helper(s); // solve inside ()
            }

            // operator OR end OR ')'
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {

                if (sign == '+') st.push(num);
                else if (sign == '-') st.push(-num);
                else if (sign == '*') st.push(st.pop() * num);
                else if (sign == '/') st.push(st.pop() / num);

                sign = c;
                num = 0;
            }

            if (c == ')') break;

            i++;
        }

        int sum = 0;
        for (int val : st) sum += val;

        return sum;
    }
}