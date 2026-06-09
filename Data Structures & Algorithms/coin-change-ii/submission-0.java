class Solution {
    public int function(int index,int target,int[][] memo,int[] coins)
    {
        if(index==0)
        {
            if(target%coins[0]==0)
                return 1;
            return 0;
        }
        if(memo[index][target]!=-1) return memo[index][target];
        int notTake=function(index-1,target,memo,coins);
        int take=0;
        if(coins[index]<=target)
            take=function(index,target-coins[index],memo,coins);
        memo[index][target]=take+notTake;
        return memo[index][target];
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] memo=new int[n][amount+1];
        for(int i=0;i<n;i++)
            Arrays.fill(memo[i],-1);
        return function(n-1,amount,memo,coins);
    }
}
