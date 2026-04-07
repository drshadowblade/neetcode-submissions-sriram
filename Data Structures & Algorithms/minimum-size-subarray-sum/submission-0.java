class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length=0,minlen=(int)(1e9);
        int sum=0;
        int left=0;
        for(int right=0;right<nums.length;right++)
        {
            sum+=nums[right];
            while(sum>=target)
            {
                minlen = Math.min(minlen, right - left + 1);
                sum-=nums[left];
                left++;
            }
        }
        return minlen==(int)(1e9) ? 0:minlen;
    }
}