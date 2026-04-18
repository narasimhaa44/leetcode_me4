class Solution {
    public int reverse(int val){
        int num=0;
        while(val>0){
            int r=val%10;
            num=num*10+r;
            val=(int)val/10;
        }
        return num;
    }
    public int mirrorDistance(int n) {
        int rev=reverse(n);
        return Math.abs(n-rev);

    }
}