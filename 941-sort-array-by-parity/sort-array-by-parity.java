class Solution {
    public int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer>list1=new ArrayList<>();
        for(int a:nums)
        {
            list1.add(a);
        }
        Collections.sort(list1,(k,l)->(k%2-(l%2)));
        int i=0;
        for(var a:list1)
        {
            nums[i++]=a;
        }
        return nums;
        
    }
}