class Solution {
    public List<Integer> getRow(int row){
        List<Integer> lp=new ArrayList<>();
        int res=1;
        lp.add(1);
        for(int i=1;i<row;i++){
            res=res*(row-i);
            res=res/i;
            lp.add(res);
        }
        return lp;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            l.add(getRow(i));
        }
        return l;
    }

}