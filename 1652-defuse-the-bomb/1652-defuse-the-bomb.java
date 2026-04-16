class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0) return res;

        int sum = 0;
        int start, end;

        if (k > 0) {
            start = 1;
            end = k;
        } else {
            start = n + k;
            end = n - 1;
        }

        // initial window sum
        for (int i = start; i <= end; i++) {
            sum += code[i % n];
        }

        for (int i = 0; i < n; i++) {
            res[i] = sum;

            // slide window
            sum -= code[start % n];
            start++;

            end++;
            sum += code[end % n];
        }

        return res;
    }
}