class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int prod=1;
        int maxprod=0;
        for(int i=0;i<n;i++)
        {
            prod=1;
            for(int j=i;j<n;j++)
            {
                prod*=nums[j];
                if(prod>maxprod)
                    maxprod=prod;
            }
        }
        return maxprod;
    }
}
