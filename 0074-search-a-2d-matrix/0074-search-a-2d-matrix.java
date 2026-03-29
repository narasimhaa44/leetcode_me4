class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int row=-1;
        for(int i=0;i<m;i++){
            if(matrix[i][n-1]>=target){
                row=i;
                break;
            }
        }
        if(row==-1) return false;
        for(int j=0;j<n;j++){
            if(matrix[row][j]==target){
                return true;
            }
        }
        return false;
    }
}