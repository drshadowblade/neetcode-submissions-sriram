class Solution {
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[] suffix=new int[n];
        int total=0;
        for(int i=n-1;i>=0;i--)
        {
            total+=piles[i];
            suffix[i]+=total;
        }
        int[][] memo=new int[n][n+1];
        for(int i=0;i<n;i++)
            Arrays.fill(memo[i],-1);
        return dp(0,1,suffix,memo);
    }
    public int dp(int i,int m,int[] suffix,int[][] memo)
    {
        if(i+2*m>=suffix.length) return suffix[i];

        if(memo[i][m]!=-1) return memo[i][m];
        int max=0;
        for(int x=1;x<=2*m;x++)
        {
            int stone=suffix[i]-dp(i+x,Math.max(m,x),suffix,memo);
            max=Math.max(max,stone);
        }
        memo[i][m]=max;
        return memo[i][m];
    }
}