class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            adjRev.add(new ArrayList<>());
        }
        int[] indegree=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            //i->it
            //it->i
            for(int it:graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> safe=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            safe.add(node);
            for(int it:adjRev.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}