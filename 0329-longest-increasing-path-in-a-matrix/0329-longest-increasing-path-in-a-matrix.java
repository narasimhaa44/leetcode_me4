class Solution {

    int[][] dp;
    int m, n;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];

        int ans = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int r, int c){

        if(dp[r][c] != 0) return dp[r][c];

        int max = 1; // at least the cell itself

        for(int k = 0; k < 4; k++){
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n
               && matrix[nr][nc] > matrix[r][c]){

                max = Math.max(max, 1 + dfs(matrix, nr, nc));
            }
        }

        dp[r][c] = max;
        return max;
    }
}
