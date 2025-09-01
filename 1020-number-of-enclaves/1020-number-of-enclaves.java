class Pair{
    int i,j;
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<=n-1;i++){
            for(int j=0;j<=m-1;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().i;
            int c=q.peek().j;
            q.remove();

            for(int i=0;i<4;i++){
                int nr=r+delrow[i];
                int nc=c+delcol[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}