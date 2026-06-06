class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int maxProd=nums[0];
        int suffix=0;
        int prefix=0;
        for(int i=0;i<n;i++)
        {
            prefix = (prefix==0 ? 1: prefix)*nums[i];
            suffix = (suffix==0 ? 1: suffix)*nums[n-1-i];

            maxProd=Math.max(maxProd,Math.max(prefix,suffix)); 
        }
        return maxProd;
    }
}
