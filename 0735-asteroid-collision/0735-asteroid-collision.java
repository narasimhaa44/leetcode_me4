class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        for(int as:asteroids){
            if(as>0){
                s.push(as);
            }
            else{
                while(!s.isEmpty() && s.peek()>0 && s.peek()<Math.abs(as)){
                    s.pop();
                }
                if(s.isEmpty() || s.peek()<0){
                    s.push(as);
                }
                else if(!s.isEmpty() && s.peek()==Math.abs(as)){
                    s.pop();
                }
            }
        }
                int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}