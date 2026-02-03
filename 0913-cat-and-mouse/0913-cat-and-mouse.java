class Solution {

    static final int DRAW = 0;
    static final int MOUSE = 1;
    static final int CAT = 2;

    int[][] graph;
    int[][][] dp;
    int n;
    int MAX_MOVES;

    public int catMouseGame(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        this.dp = new int[n][n][2];
        this.MAX_MOVES = 2 * n * n;

        return dfs(1, 2, 0, 0);
    }

    int dfs(int mouse, int cat, int turn, int moves) {

        // move limit → draw
        if (moves >= MAX_MOVES) return DRAW;

        // base cases
        if (mouse == 0) return MOUSE;
        if (mouse == cat) return CAT;

        if (dp[mouse][cat][turn] != 0)
            return dp[mouse][cat][turn];

        if (turn == 0) { // Mouse turn
            boolean canDraw = false;
            for (int next : graph[mouse]) {
                int res = dfs(next, cat, 1, moves + 1);
                if (res == MOUSE)
                    return dp[mouse][cat][turn] = MOUSE;
                if (res == DRAW)
                    canDraw = true;
            }
            return dp[mouse][cat][turn] = canDraw ? DRAW : CAT;
        } 
        else { // Cat turn
            boolean canDraw = false;
            for (int next : graph[cat]) {
                if (next == 0) continue;
                int res = dfs(mouse, next, 0, moves + 1);
                if (res == CAT)
                    return dp[mouse][cat][turn] = CAT;
                if (res == DRAW)
                    canDraw = true;
            }
            return dp[mouse][cat][turn] = canDraw ? DRAW : MOUSE;
        }
    }
}
