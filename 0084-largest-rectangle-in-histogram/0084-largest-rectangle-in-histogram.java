class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int maxarea=0;
        int element,nse,pse;
        for(int i=0;i<=heights.length-1;i++){
            while(!s.isEmpty() && heights[s.peek()]>heights[i]){
                    element=s.pop();
                    nse=i;
                    pse=s.isEmpty()?-1:s.peek();
                    maxarea=Math.max(maxarea,heights[element]*(nse-pse-1));
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            nse=heights.length;
            element=s.pop();
            pse=s.isEmpty()?-1:s.peek();
            maxarea=Math.max(maxarea,heights[element]*(nse-pse-1));
        }
        return maxarea;
    }
}