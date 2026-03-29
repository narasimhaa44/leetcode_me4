class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        // Step 2: Traverse and merge
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) { // overlap
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i]; // move to next disjoint interval
            }
        }

        // Step 3: Add last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
