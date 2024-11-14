class Solution {
    public int minPatches(int[] nums, int n) {
        int i=0;
        int count=0;
        long sum=0;
        int len=nums.length;

        while(i<len&&sum<n){
          if(sum+1>=nums[i]){
             sum+=nums[i];
             i++;
          }
          else{
             count++;
             sum+=sum+1;
             System.out.println(sum);
          }
        }

        while(sum<n){
         sum=sum+sum+1;
          System.out.println(sum);
         count++;
        }
       return count; 
    }
}