class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int first=robLinear(nums,0,nums.length-2);
        int second=robLinear(nums,1,nums.length-1);
        return Math.max(first,second);
    }
    public int robLinear(int[] nums,int start,int end)
    {
        int prev1=0;
        int prev2=0;
        for(int i=start;i<=end;i++)
        {
            int current=Math.max(nums[i]+prev1,prev2);
            prev1=prev2;
            prev2=current;
        }
        return prev2;
    }
}
