class Solution {
    public int jump(int[] nums) {
        int maxreach=0;
        int reach=0;
        int jump=0;
        for(int i=0;i<nums.length-1;i++)
        {
            maxreach=Math.max(maxreach,i+nums[i]);
            if(i==reach)
            {
                jump++;
                reach=maxreach;
            }
        }
        return jump;
    }
}
