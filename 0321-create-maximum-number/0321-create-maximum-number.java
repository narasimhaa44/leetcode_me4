// // class Solution {
// //     public int[] maxNumber(int[] nums1, int[] nums2, int k) {
// //         int m=nums1.length;
// //         int n=nums2.length;
// //         int sum1=0;
// //         int sum2=0;
// //         for(int i=0;i<m;i++){
// //             sum1+=nums1[i];
// //         }
// //         for(int i=0;i<n;i++){
// //             sum2+=nums2[i];
// //         }
// //         if(sum1>sum2){
// //             for(int i=m-2;i>=0;i--){
// //                 if(nums[i+1]<nums[i]){
// //                     then remove the valley tillt he sum is less than the second array or till its size is less than the second array
// //                 }
// //             }
// //         }
// //         else if(sum2>=sum1){

// //         }
// //     }
// // }
// import java.util.*;

// class Solution {

//     public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//         int m = nums1.length, n = nums2.length;
//         int[] ans = new int[k];

//         for (int i = 0; i <= k; i++) {
//             if (i <= m && (k - i) <= n) {

//                 int[] a = maxSubsequence(nums1, i);
//                 int[] b = maxSubsequence(nums2, k - i);

//                 int[] merged = merge(a, b);

//                 if (greater(merged, 0, ans, 0)) {
//                     ans = merged;
//                 }
//             }
//         }
//         return ans;
//     }

//     // 🔥 get max subsequence using monotonic stack
//     private int[] maxSubsequence(int[] nums, int k) {
//         int n = nums.length;
//         Stack<Integer> st = new Stack<>();
//         int drop = n - k;

//         for (int num : nums) {
//             while (!st.isEmpty() && drop > 0 && st.peek() < num) {
//                 st.pop();
//                 drop--;
//             }
//             st.push(num);
//         }

//         int[] res = new int[k];
//         for (int i = k - 1; i >= 0; i--) {
//             res[i] = st.pop();
//         }
//         return res;
//     }

//     // 🔥 merge two arrays greedily
//     private int[] merge(int[] a, int[] b) {
//         int[] res = new int[a.length + b.length];
//         int i = 0, j = 0, r = 0;

//         while (i < a.length || j < b.length) {
//             if (greater(a, i, b, j)) {
//                 res[r++] = a[i++];
//             } else {
//                 res[r++] = b[j++];
//             }
//         }
//         return res;
//     }

//     // 🔥 compare lexicographically
//     private boolean greater(int[] a, int i, int[] b, int j) {
//         while (i < a.length && j < b.length && a[i] == b[j]) {
//             i++;
//             j++;
//         }
//         return j == b.length || (i < a.length && a[i] > b[j]);
//     }
// }\

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] best = new int[k];

        for (int i = Math.max(0, k - n2); i <= Math.min(k, n1); i++) {
            int[] ss1 = pmc(nums1, i); 
            int[] ss2 = pmc(nums2, k - i);
            int[] c = merge(ss1, ss2, k);
            if (greater(c, 0, best, 0)) {
                best = c;
            }
        }
        return best;
    }

    private int[] pmc(int[] nums, int t) {
        if (t == 0) return new int[0];
        Deque<Integer> st1 = new LinkedList<>(); 
        int toRemove = nums.length - t; // how many elements we can drop

        for (int x : nums) {
            while (!st1.isEmpty() && st1.peekLast() < x && toRemove > 0) {
                st1.removeLast();
                toRemove--;
            }
            st1.addLast(x);
        }
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            res[i] = st1.removeFirst();
        }
        return res;
    }

    private int[] merge(int[] a, int[] b, int k) {
        int[] res = new int[k];
        int i = 0, j = 0, r = 0;
        while (r < k) {
            if (greater(a, i, b, j)) {
                res[r++] = a[i++];
            } else {
                res[r++] = b[j++];
            }
        }
        return res;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        int n = a.length, m = b.length;
        while (i < n && j < m) {
            if (a[i] != b[j]) return a[i] > b[j];
            i++; j++;
        }
        return (n - i) > (m - j);//else the one with the more length will be considered as greater 
    }
}