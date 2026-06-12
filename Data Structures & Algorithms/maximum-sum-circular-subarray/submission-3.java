class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int global_min=Integer.MAX_VALUE;
        int global_max=Integer.MIN_VALUE;
        int curMax=0;
        int curMin=0;
        int total=0;
        for(int i=0;i<nums.length;i++)
        {
            curMax=Math.max(nums[i],curMax+nums[i]);
            global_max=Math.max(curMax,global_max);

            curMin=Math.min(nums[i],curMin+nums[i]);
            global_min=Math.min(curMin,global_min);

            total+=nums[i];
        }

        if(global_max<0)
            return global_max;
        
        return Math.max(global_max,total-global_min);
    }
}