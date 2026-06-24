class Solution {
    public boolean find132pattern(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int third = Integer.MIN_VALUE; // nums[k]

        for(int i = n - 1; i >= 0; i--){

            // if nums[i] < nums[k]
            if(nums[i] < third){
                return true;
            }

            while(!st.isEmpty() && nums[i] > st.peek()){
                third = st.pop(); // candidate for nums[k]
            }

            st.push(nums[i]);
        }

        return false;
    }
}