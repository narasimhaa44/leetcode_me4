// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int minisum=0;
//         for(int i=0;i<=arr.length-1;i++){
//             for(int j=i;j<=arr.length-1;j++){
//                 List<Integer> l=new ArrayList<>();
//                 for(int k=i;k<=j;k++){
//                     l.add(arr[k]);
//                 }
//                 int min=l.get(0);
//                 for(int p=1;p<=l.size()-1;p++){
//                     if(l.get(p)<min){
//                         min=l.get(p);
//                     }
//                 }
//                 minisum+=min;
//             }
//         }
//         return minisum;
//     }
// }
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = (int)1e9 + 7;
        Stack<Integer> stack = new Stack<>();

        int[] prev = new int[n];
        int[] next = new int[n];

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Total sum
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            sum = (sum + arr[i] * left * right) % MOD;
        }

        return (int)sum;
    }
}
