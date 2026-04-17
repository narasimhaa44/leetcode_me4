// class Solution {
//     public int reverse(int val){
//         int num=0;
//         while(val>0){
//             int r=val%10;
//             num=num*10+r;
//             val=(int)val/10;
//         }
//         return num;
//     }
//     public int minMirrorPairDistance(int[] nums) {
//         int minval;
//         for(int i=0;i<nums.length;i++){
//             int p=reverse(nums[i]);
//             minval=Integer.MAX_VALUE;
//             for(int j=i+1;j<nums.length;j++){
//                 if(p==nums[j]){
//                     minval=Math.min(minval,Math.abs(j-i));
//                 }
//             }
//         }
//         return minval;
//     }
// }
class Solution {
    public int reverse(int val){
        int num = 0;

        while(val != 0){
            int r = val % 10;
            num = num * 10 + r;
            val /= 10;
        }

        return num;
    }

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minval = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int rev = reverse(nums[i]);

            for(int j = i + 1; j < n; j++){
                if(nums[j] == rev){
                    minval = Math.min(minval, j - i);
                }
            }
        }

        return minval == Integer.MAX_VALUE ? -1 : minval;
    }
}