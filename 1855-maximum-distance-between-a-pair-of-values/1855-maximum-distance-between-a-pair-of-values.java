// class Solution {
//     public int maxDistance(int[] nums1, int[] nums2) {
//         int n=nums1.length;
//         int m=nums2.length;
//         int maxdist=Integer.MIN_VALUE;
//         for(int i=0;i<n;i++){
//             for(int j=i;j<m;j++){
//                 if(nums1[i]<=nums2[j]){
//                     maxdist=Math.max(maxdist,Math.abs(j-i));
//                 }else{
//                     break;
//                 }
//             }
//         }
//         return maxdist==Integer.MIN_VALUE?0:maxdist;
//     }
// }
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int maxDist = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] <= nums2[j]) {
                maxDist = Math.max(maxDist, j - i);
                j++; // expand
            } else {
                i++; // move i forward
                if (i > j) j = i; // maintain j ≥ i
            }
        }

        return maxDist;
    }
}