class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int cnt=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int[][] isConnected,boolean[] vis,int node){
        vis[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i]==1 && !vis[i]){
                dfs(isConnected,vis,i);
            }
        }
    }
}