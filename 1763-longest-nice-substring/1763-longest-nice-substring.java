class Solution {

    public String longestNiceSubstring(String s) {
        return solve(s);
    }

    private String solve(String s) {

        // base case
        if (s.length() < 2) return "";

        // store all characters
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        // check each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // if both cases exist → continue
            if (set.contains(Character.toLowerCase(c)) &&
                set.contains(Character.toUpperCase(c))) {
                continue;
            }

            // ❌ invalid char → split
            String left = solve(s.substring(0, i));
            String right = solve(s.substring(i + 1));

            // return longer one
            return left.length() >= right.length() ? left : right;
        }

        // whole string is valid
        return s;
    }
}