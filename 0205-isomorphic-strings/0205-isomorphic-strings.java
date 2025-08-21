class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Maps for both directions
        int[] mapS = new int[256];  // s -> t
        int[] mapT = new int[256];  // t -> s

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // If mapping already exists, check consistency
            if (mapS[cs] == 0 && mapT[ct] == 0) {
                mapS[cs] = ct;
                mapT[ct] = cs;
            } else {
                if (mapS[cs] != ct || mapT[ct] != cs) {
                    return false;
                }
            }
        }
        return true;
    }
}
