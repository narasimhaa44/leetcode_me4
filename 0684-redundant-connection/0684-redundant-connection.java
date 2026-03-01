
// class Solution {

//     // Performs DFS and returns true if there's a path between src and target.
//     private boolean isConnected(
//         int src,
//         int target,
//         boolean[] visited,
//         List<Integer>[] adjList
//     ) {
//         visited[src] = true;

//         if (src == target) {
//             return true;
//         }

//         boolean isFound = false;
//         for (int adj : adjList[src]) {
//             if (!visited[adj]) {
//                 isFound = isFound || isConnected(adj, target, visited, adjList);
//             }
//         }

//         return isFound;
//     }

//     public int[] findRedundantConnection(int[][] edges) {
//         int N = edges.length;

//         List<Integer>[] adjList = new ArrayList[N];
//         for (int i = 0; i < N; i++) {
//             adjList[i] = new ArrayList<>();
//         }

//         for (int[] edge : edges) {
//             boolean[] visited = new boolean[N];

//             // If DFS returns true, we will return the edge.
//             if (isConnected(edge[0] - 1, edge[1] - 1, visited, adjList)) {
//                 return new int[] { edge[0], edge[1] };
//             }

//             adjList[edge[0] - 1].add(edge[1] - 1);
//             adjList[edge[1] - 1].add(edge[0] - 1);
//         }

//         return new int[] {};
//     }
// }
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
    public int[] findRedundantConnection(int[][] edges) {
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