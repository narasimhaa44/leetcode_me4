class Solution {
    public List<Integer> majorityElement(int[] nums) {
     HashMap<Integer, Integer> map = new HashMap<>();
     List<Integer> l=new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length / 3 && !l.contains(num)) {
                l.add(num);
            }
        }

        return l;
    }
}