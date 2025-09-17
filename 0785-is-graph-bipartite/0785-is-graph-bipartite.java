// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int[] color=new int[graph[0].length];
//         for(int i=0;i<graph[0].length;i++){
//             color[i]=-1;
//         }
//         for(int i=0;i<graph[0].length;i++){
//             if(color[i]==-1){
//                 if(dfs(i,0,color,graph)==false){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean dfs(int i,int col,int[] color,int[][] graph){
//         color[i]=col;
//         for(int it:graph[i]){
//             if(color[it]==-1){
//                 if(dfs(it,1-col,color,graph)==false){
//                     return false;
//                 }
//             }
//             else if(color[it]==col){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        // Initialize all nodes as uncolored (-1)
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        
        // Try to color each disconnected component
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;
        
        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - col, color, graph)) {
                    return false;
                }
            } else if (color[neighbor] == col) {
                return false;  // Neighbor has same color → Not bipartite
            }
        }
        
        return true;
    }
}
