class Solution {
    public boolean isSelfCrossing(int[] distance) {     
        for (int i = 0; i < distance.length; i++) {     
            // Important remarks:
            // - There are only three crossing ways.
            // - Due to the spiral nature, for each new line 
            //   we need to consider the only five lines before.       
            if (i >= 3 && checkIfCrossWith3th(distance, i)) {                
                return true;
            }               
            if (i >= 4 && checkIfCrossWith4th(distance, i)) {                
                return true;
            }               
            if (i >= 5 && checkIfCrossWith5th(distance, i)) {            
                return true;
            }                  
        }
        return false;
    }

    // Legend:
    //   "x" - the lines crossed
    //   "shift - 0" the line that crossed another line
    //   "shift - 1" the line one before the line that crossed
    //   "shift - N" the Nth line before the line that crossed
    //   
    // distance = [4, 6, 1, 9, ...whatever]
    //
    //                shift - 2
    //               - - - - - -
    //  shift - 1  |             | shift - 3
    //               - - - - - - x - -
    //              shift - 0    |
    //           (the last line) |
    //
    private boolean checkIfCrossWith3th(int[] array, int shift) {
        // "shift - 0" instead of just "shift" for the sake of coherency
        return array[shift - 0] >= array[shift - 2] 
            && array[shift - 1] <= array[shift - 3];
    }

    // distance = [8, 6, 9, 14, 2, 10, ...whatever]  
    //
    //                shift - 4
    //               - - - - - -
    //             |             | shift - 5 
    //             |             | 
    //             |             | 
    //  shift - 3  |             |       shift - 0 (the last line)
    //             |             |        |
    //             |             |       \|/
    //             |         - - x - - - - - - -             
    //             |             |              | 
    //             |                            | shift - 1 (line before)
    //               - - - - - - - - - - - - - - 
    //                        shift - 2
    //
    private boolean checkIfCrossWith5th(int[] array, int shift) {
        return array[shift - 2] > array[shift - 4] 
            && array[shift - 0] + array[shift - 4] >= array[shift - 2]
            && array[shift - 3] - array[shift - 1] >= 0
            && array[shift - 3] - array[shift - 1] <= array[shift - 5];
    }

    // distance = [4, 5, 6, 5, 2, ...whatever]  
    //
    //                shift - 3
    //               - - - - -
    //             |           |   
    //             |           |   shift - 4
    //  shift - 2  |           |       
    //             |           x
    //             |           |              
    //             |           |   shift - 0 (the last line)            
    //               - - - - - 
    //                shift - 1
    //
    private boolean checkIfCrossWith4th(int[] array, int shift) {
        return array[shift - 1] == array[shift - 3]
            && array[shift - 2] - array[shift - 0] <= array[shift - 4];
    }
}