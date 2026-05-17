// class Solution {
//     public int countGoodSubstrings(String s) {

//         HashMap<Character, Integer> map = new HashMap<>();
//         int left = 0, count = 0;

//         for (int right = 0; right < s.length(); right++) {

//             // add current char
//             char c = s.charAt(right);
//             map.put(c, map.getOrDefault(c, 0) + 1);

//             // maintain window size = 3
//             if (right - left + 1 > 3) {
//                 char leftChar = s.charAt(left);
//                 map.put(leftChar, map.get(leftChar) - 1);
//                 if (map.get(leftChar) == 0) {
//                     map.remove(leftChar);
//                 }
//                 left++;
//             }

//             // check valid substring
//             if (right - left + 1 == 3 && map.size() == 3) {
//                 count++;
//             }
//         }

//         return count;
//     }
// }
class Solution {
    public int countGoodSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if (a != b && b != c && a != c) {
                count++;
            }
        }

        return count;
    }
}