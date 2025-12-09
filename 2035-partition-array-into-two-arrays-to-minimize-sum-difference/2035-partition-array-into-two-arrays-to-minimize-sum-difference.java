// class Solution {
//     public int minimumDifference(int[] nums) {
//         int totsum=0;
//         for(int i=0;i<nums.length;i++){
//             totsum+=nums[i];
//         }
//         boolean[][] dp=new boolean[nums.length][totsum+1];
//         for(int i=0;i<nums.length;i++){
//             dp[i][0]=true;
//         }
//                 if(nums[0] >= 0 && nums[0] <= totsum)
//             dp[0][nums[0]] = true;
//         for(int i=1;i<nums.length;i++){
//             for(int target=0;target<=totsum;target++){
//                 boolean nottake=dp[i-1][target];
//                 boolean take=false;
//                 if(nums[i]<=target){
//                     take=dp[i-1][target-nums[i]];
//                 }
//                 dp[i][target]=take || nottake;
//             }
//         }
//         int mini=(int)1e7;
//         for(int i=0;i<=totsum/2;i++){
//             if(dp[nums.length-1][i]==true){
//                 mini=Math.min(mini,Math.abs((totsum-i)-i));
//             }
//         }
//         System.out.println(mini);
//         return mini;
//     }
// }
class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, nums.length);

        List<List<Integer>> leftSums = generate(left);
        List<List<Integer>> rightSums = generate(right);

        int total = 0;
        for (int x : nums) total += x;

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> a = leftSums.get(k);
            List<Integer> b = rightSums.get(n - k);

            Collections.sort(b);

            for (int x : a) {
                int target = (total - 2 * x) / 2;

                int idx = Collections.binarySearch(b, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < b.size())
                    ans = Math.min(ans, Math.abs(total - 2 * (x + b.get(idx))));

                if (idx > 0)
                    ans = Math.min(ans, Math.abs(total - 2 * (x + b.get(idx - 1))));
            }
        }

        return ans;
    }

    private List<List<Integer>> generate(int[] arr) {
        int m = arr.length;
        int total = 1 << m;

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= m; i++) res.add(new ArrayList<>());

        for (int mask = 0; mask < total; mask++) {
            int bits = Integer.bitCount(mask);
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) > 0)
                    sum += arr[i];
            }
            res.get(bits).add(sum);
        }
        return res;
    }
}
