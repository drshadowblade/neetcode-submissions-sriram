class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int s=0;
        int n=nums.length;
        for(int i=0;i<=n;i++)
            sum+=i;
        for(int i=0;i<n;i++)
            s+=nums[i];
        return sum-s;
    }
}
