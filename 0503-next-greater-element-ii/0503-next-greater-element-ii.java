class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n];
            while (!s.isEmpty() && s.peek() <= curr) {
                s.pop();
            }
            if (i < n) {
                nge[i] = s.isEmpty() ? -1 : s.peek();
            }
            s.push(curr);
        }
        return nge;
    }
}
