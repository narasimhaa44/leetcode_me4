class Solution {
    static int cnt=0;
    public boolean ways(int i,int j,int m,int n){
        if(i>m-1 || j>n-1){
            return false;
        }
        if(i==m-1 && j==n-1){
            cnt++;
            return true;
        }
        ways(i,j+1,m,n);
        ways(i+1,j,m,n);
        return false;
    }
    public int uniquePaths(int m, int n) {
        cnt=0;
        ways(0,0,m,n);
        return cnt;
    }
}