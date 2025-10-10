class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length==1){
            return intervals;
        }
        else{
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=intervals[i-1][1]){
                intervals[i][0]=Math.min(intervals[i][0],intervals[i-1][0]);
                intervals[i][1]=Math.max(intervals[i][1],intervals[i-1][1]);
                result.add(intervals[i]);
            }
            else{
                result.add(intervals[i]);
                result.add(intervals[i-1]);
            }
        }
        }
        return result.toArray(new int[result.size()][]);
    }
}