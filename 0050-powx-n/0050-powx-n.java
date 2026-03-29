class Solution {
    public double myPow(double x, int n) {
        double res=Math.abs(n);
        double ans;
        if(n >0){
            while(n>0){
                res=x**res;
                n--;
            }
            ans=res;
        }
        else if(n<0){
            while(Math.abs(n)>0){
                res=x**res;
                n++;
            }
            ans=(double)(1/res);
        }
        else{
            ans=(double)1;
        }
        return ans;
    }
}