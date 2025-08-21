import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Bucket sort (index = frequency)
        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : freq.keySet()) {
            int f = freq.get(c);
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(c);
        }

        // Step 3: Build result (from high freq → low)
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int k = 0; k < i; k++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
