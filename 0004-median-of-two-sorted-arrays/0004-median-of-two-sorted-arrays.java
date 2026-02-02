class Solution {

    public int[] mergeSorted(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] res = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }

        while (i < n) res[k++] = a[i++];
        while (j < m) res[k++] = b[j++];

        return res;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged = mergeSorted(nums1, nums2);
        int len = merged.length;

        if (len % 2 == 0) {
            int p = merged[len / 2 - 1];
            int q = merged[len / 2];
            return (p + q) / 2.0;
        } else {
            return merged[len / 2];
        }
    }
}
