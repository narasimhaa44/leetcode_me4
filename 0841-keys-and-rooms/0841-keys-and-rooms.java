class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        // start DFS from room 0
        dfs(0, rooms, visited);
        
        // check if all rooms visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    
    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;
        
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
