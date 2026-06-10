class Solution {
    public int function(int idx,int op,int[] prices,int[][] memo)
    {
        if(idx==prices.length) return 0;
        if(memo[idx][op]!=-1) return memo[idx][op];
        if(op==1)
        {
            memo[idx][op]=Math.max(-prices[idx]+function(idx+1,0,prices,memo),0+function(idx+1,1,prices,memo));
        }
        else if(op==0)
        {
            memo[idx][op]=Math.max(prices[idx]+function(idx+1,2,prices,memo),0+function(idx+1,0,prices,memo));
        }
        else
            memo[idx][op]=function(idx+1,1,prices,memo);
        return memo[idx][op];
    }
    public int maxProfit(int[] prices) {
        int[][] memo=new int[prices.length][3];
        for(int i=0;i<prices.length;i++)
            Arrays.fill(memo[i],-1);
        return function(0,1,prices,memo);
    }
}
