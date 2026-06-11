class Solution {
    public int function(int[] nums,int idx,int target,int sum)
    {
        if(idx==nums.length){
            if(sum==target)
            {
                return 1;
            }
            return 0;
        }
        int add=function(nums,idx+1,target,sum+nums[idx]);
        int sub=function(nums,idx+1,target,sum-nums[idx]);

        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return function(nums,0,target,0);
    }
}
