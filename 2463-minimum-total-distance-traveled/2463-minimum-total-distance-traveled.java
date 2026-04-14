import java.util.*;

class Solution {
    Long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        dp = new Long[robot.size()][factory.length];

        return solve(0, 0, robot, factory);
    }

    private long solve(int i, int j, List<Integer> robot, int[][] factory) {
        // all robots assigned
        if (i == robot.size()) return 0;

        // no factories left
        if (j == factory.length) return Long.MAX_VALUE;

        if (dp[i][j] != null) return dp[i][j];

        long ans = solve(i, j + 1, robot, factory); // skip

        long cost = 0;

        // assign k robots to this factory
        for (int k = 0; k < factory[j][1] && i + k < robot.size(); k++) {
            cost += Math.abs(robot.get(i + k) - factory[j][0]);

            long next = solve(i + k + 1, j + 1, robot, factory);

            if (next != Long.MAX_VALUE) {
                ans = Math.min(ans, cost + next);
            }
        }

        return dp[i][j] = ans;
    }
}