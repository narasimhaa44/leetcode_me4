class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];  // start with first word

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { 
                // shrink prefix until it matches the beginning of strs[i]
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
