class DSU{
    int[] parent;
    int[] size;
    public DSU(int n){
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int u){
        if(parent[u]!=u){
            parent[u]=find(parent[u]);
        }
        return parent[u];
    }
    public boolean UnionBySize(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv) return true;
        if(size[pu]>=size[pv]){
            parent[pv]=pu;
            size[pu]+=size[pv];
        }      
        else if(size[pv]>size[pu]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }
        return false;
    }

}
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        DSU ds=new DSU(edges.length);
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(ds.UnionBySize(u,v)){
                return edge;
            }
        }
        return new int[0];
    }
}