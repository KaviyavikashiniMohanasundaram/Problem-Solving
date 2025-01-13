class Solution {
    public int maxProduct(int[] nums) {
        int pre = 1, post = 1, ans = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pre = (pre == 0 ? 1 : pre) * nums[i];
            post = (post == 0 ? 1 : post) * nums[n - i - 1];
            ans = Math.max(ans, Math.max(pre, post));
        }
        return ans;
    }
}