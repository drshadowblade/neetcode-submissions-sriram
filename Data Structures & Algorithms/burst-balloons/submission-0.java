class Solution {
    public int function(int[] a,int i,int j,int[][] memo)
    {
        if(i>j) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int maxi=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++)
        {
            int cost=(a[i-1]*a[ind]*a[j+1])+function(a,i,ind-1,memo)+function(a,ind+1,j,memo);
            maxi=Math.max(maxi,cost);
        }
        memo[i][j]=maxi;
        return memo[i][j];
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] a=new int[n+2];
        a[0]=1;
        a[n+1]=1;
        for(int i=1;i<n+1;i++)
            a[i]=nums[i-1];
        int[][] memo=new int[n+2][n+2];
        for(int i=0;i<=n;i++)
            Arrays.fill(memo[i],-1);
        return function(a,1,n,memo);
    }
}
