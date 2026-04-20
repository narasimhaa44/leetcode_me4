class Solution {
    public int maxDistance(int[] colors) {
        int start=colors[0];
        int maxdist=Integer.MIN_VALUE;
        for(int i=1;i<colors.length;i++){
            if(colors[i]!=start){
                maxdist=Math.max(maxdist,Math.abs(0-i));
            }
        }
        return maxdist;
    }
}