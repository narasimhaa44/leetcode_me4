class Solution {
    static final int DRAW = 0;
    static final int MOUSE = 1;
    static final int CAT = 2;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;

        int[][][] color = new int[n][n][2];
        int[][][] degree = new int[n][n][2];

        // initialize degrees
        for (int m = 0; m < n; m++) {
            for (int c = 0; c < n; c++) {
                degree[m][c][0] = graph[m].length;
                degree[m][c][1] = graph[c].length;
                for (int x : graph[c]) {
                    if (x == 0) degree[m][c][1]--;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        // base cases
        for (int i = 0; i < n; i++) {
            for (int t = 0; t < 2; t++) {
                if (i != 0) {
                    color[0][i][t] = MOUSE;
                    q.offer(new int[]{0, i, t});
                }
                color[i][i][t] = CAT;
                q.offer(new int[]{i, i, t});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int m = cur[0], c = cur[1], t = cur[2];
            int curColor = color[m][c][t];

            for (int[] prev : parents(graph, m, c, t)) {
                int pm = prev[0], pc = prev[1], pt = prev[2];
                if (color[pm][pc][pt] != DRAW) continue;

                if ((pt == 0 && curColor == MOUSE) ||
                    (pt == 1 && curColor == CAT)) {
                    color[pm][pc][pt] = curColor;
                    q.offer(new int[]{pm, pc, pt});
                } else {
                    degree[pm][pc][pt]--;
                    if (degree[pm][pc][pt] == 0) {
                        color[pm][pc][pt] = (pt == 0) ? CAT : MOUSE;
                        q.offer(new int[]{pm, pc, pt});
                    }
                }
            }
        }

        return color[1][2][0];
    }

    private List<int[]> parents(int[][] graph, int m, int c, int t) {
        List<int[]> res = new ArrayList<>();
        if (t == 1) {
            for (int pm : graph[m]) {
                res.add(new int[]{pm, c, 0});
            }
        } else {
            for (int pc : graph[c]) {
                if (pc != 0)
                    res.add(new int[]{m, pc, 1});
            }
        }
        return res;
    }
}
