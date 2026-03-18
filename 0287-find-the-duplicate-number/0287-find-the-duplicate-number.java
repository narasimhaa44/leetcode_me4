// class Solution {
//     public int findDuplicate(int[] nums) {
//         // int sum=0;
//         // int k=0;
//         // for(int i=1;i<nums.length;i++){
//         //     sum+=nums[i];
//         // }
//         // for(int i=1;i<=nums.length;i++){
//         //     k+=i;
//         // }
//         // return k-sum;
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]==nums[j]){
//                     return nums[i];
//                 }
//             }
//         }
//         return 0;
//     }
// }
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Step 1: detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: find entrance
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}