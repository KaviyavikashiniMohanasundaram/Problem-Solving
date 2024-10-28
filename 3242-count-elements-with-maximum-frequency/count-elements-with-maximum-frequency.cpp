class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int ans=1;
        int maxF=1;
        for(int i=1;i<nums.size();++i){
            int f=1;
            while(i<nums.size() && nums[i]==nums[i-1]){
                f++;
                i++;
            }
            if(maxF<f){
                maxF=f;
                ans=f;
            }
            else if(f==maxF){
                ans+=f;
            }
        }
        return ans;
    }
};