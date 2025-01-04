class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int [] n = new int[101];
        for(int i: nums){
            if(n[i]++>=2)
                return false;
        }
        return true;
    }
}