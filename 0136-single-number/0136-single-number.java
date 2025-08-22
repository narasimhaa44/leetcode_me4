class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
                for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}