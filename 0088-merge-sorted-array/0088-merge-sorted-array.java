class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int k=0;
        int[] nums=new int[n+m];
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                nums[k]=nums1[i];
                i++;
                k++;
            }
            else if(nums1[i]>nums2[j]){
                nums[k]=nums2[j];
                j++;
                k++;
            }
        }
        if(i<m){
            while(i<m){
                nums[k]=nums1[i];
                k++;
                i++;
            }
        }
        else if(j<n){
            while(j<n){
                nums[k]=nums2[j];
                k++;
                j++;
            }
        }
        for(int p=0;p<nums1.length;p++){
            nums1[p]=nums[p];
        }
    }
}