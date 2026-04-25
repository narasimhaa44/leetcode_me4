// class Solution {
//     public int maxDistance(int side, int[][] points, int k) {
        
//     }
// }
class Solution {
    public int maxDistance(int side, int[][] points, int k) {

        List<Integer> arr = new ArrayList<>();

        // convert to 1D
        for (int[] p : points) {
            int x = p[0], y = p[1];

            if (y == 0) arr.add(x);
            else if (x == side) arr.add(side + y);
            else if (y == side) arr.add(2 * side + (side - x));
            else arr.add(3 * side + (side - y));
        }

        Collections.sort(arr);

        int low = 0, high = 4 * side, ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (can(arr, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(List<Integer> arr, int k, int dist) {
        int count = 1;
        int last = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - last >= dist) {
                count++;
                last = arr.get(i);
            }
        }

        return count >= k;
    }
}