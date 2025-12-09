class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int[] vis=new int[g.length];
        Arrays.sort(g); 
        Arrays.sort(s);
        for(int i=0;i<g.length;i++){
            vis[i]=0;
        }
        for(int i=0;i<s.length;i++){
            for(int j=0;j<g.length;j++){
                if(s[i]>=g[j] && vis[j]==0){
                    vis[j]=1;
                    break;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<g.length;i++){
            if(vis[i]!=0){
                cnt++;
            }
        }
        return cnt;
    }
}