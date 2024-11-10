class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size() ;
        int idx = -1  ; // pivot index == idx 
        // STEP 1 : TO FIND THE PIVOT INDEX 
        for ( int i = n-2 ; i >= 0 ; i-- ) 
        {
            if (nums[i] < nums[i+1] ) 
            {
                idx = i ; 
                break ; 
            }
        }  
        if (idx == -1 ) 
        {
            reverse(nums.begin(),nums.end()) ;
            return ;
        }
        // STEP 2 : REVERSE THE PART OF THE ARRAY FROM IDX+1 TO N-1 
        reverse(nums.begin()+idx+1,nums.end()) ;
        //step 3 : FINDING THE JUST GREATER NUMBER THAN THE NUMBER PRESENT AT PIVOT INDEX 
        int j = -1 ; 
        for ( int i = idx+1 ; i < n ; i++ )
        {
              if ( nums[i] > nums[idx])
              {
                j = i ; 
                break ; 
              }
        }
        //STEP 4 : SWAPPING THE NUMBERS PRESENT AT THE INDICES IDX AND J 
        int temp = nums[idx] ;
        nums[idx] = nums[j] ;
        nums[j] = temp ;
        return ; 
    }
};