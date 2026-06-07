class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int[] dp=new int[4];
        for(int i=n-1;i>=0;i--)
        {
            int take1=stoneValue[i]-dp[(i+1)%4];
            int take2=Integer.MIN_VALUE;
            if(i+1<=n-1){
                take2=(stoneValue[i]+stoneValue[i+1]-dp[(i+2)%4]);
            }
            int take3=Integer.MIN_VALUE;
            if(i+2<=n-1){
                take3=(stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp[(i+3)%4]);
            }
            dp[i%4]=Math.max(take1,Math.max(take2,take3));
        }
        if(dp[0]>0)
            return "Alice";
        else if(dp[0]<0)
            return "Bob";
        else
            return "Tie";
    }
}