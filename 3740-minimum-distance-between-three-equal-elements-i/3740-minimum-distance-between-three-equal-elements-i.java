// class Solution {
//     public int minimumDistance(int[] nums) {
        
//     }
// }
class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;

        // Step 2: check triplets
        for (ArrayList<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i <= list.size() - 3; i++) {
                    int first = list.get(i);
                    int third = list.get(i + 2);

                    int distance = 2 * (third - first);
                    ans = Math.min(ans, distance);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}