class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        Map<Integer, Integer> map = new HashMap<>(nums.length, 1.0f);
        for (int val : nums) 
        {
            map.merge(val, 1, Integer::sum);
        }
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) 
        {
            int val = e.getKey(), freq = e.getValue();
            reverseMap.computeIfAbsent(freq, x -> new ArrayList<>()).add(val);
            maxFreq = Math.max(maxFreq, freq);
        }
        int[] res = new int[k];
        for (int i = maxFreq, j = 0; i > 0 && j < k; i--) 
        {
            List<Integer> list = reverseMap.get(i);
            if (list != null) 
            {
                for (int x = 0; x < list.size() && j < k; x++, j++) 
                {
                    res[j] = list.get(x);
                }
            }
        }
        return res;
    }
}