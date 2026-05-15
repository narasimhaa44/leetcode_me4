import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= s.length() - 10; i++) {

            String sub = s.substring(i, i + 10);

            map.put(sub, map.getOrDefault(sub, 0) + 1);

            // Add only once when count becomes 2
            if (map.get(sub) == 2) {
                res.add(sub);
            }
        }

        return res;
    }
}