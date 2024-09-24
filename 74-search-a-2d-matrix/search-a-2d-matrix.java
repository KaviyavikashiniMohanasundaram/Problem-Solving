class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
    int rows= matrix.length;
    int cols= matrix[0].length;
    int low= 0;
    int high=rows * cols - 1;
    while(low <= high)
    {
      int mid = (low + high) / 2;
      int mid_value = matrix[mid / cols][mid % cols];
        
        if (mid_value == target)
            return true;
        else if(mid_value < target)
            low = mid + 1;
        else
            high = mid - 1;
    }
    
    return false;
    }
}

