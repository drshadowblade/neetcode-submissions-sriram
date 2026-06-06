class Solution {
    public int numDecodings(String s) {
        if(s.length()==0 || s.charAt(0)=='0' || s==null)
            return 0; 
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int oneDig=Integer.parseInt(s.substring(i-1,i));
            if(oneDig>=1 && oneDig<=9)
                dp[i]+=dp[i-1];
            int twoDig=Integer.parseInt(s.substring(i-2,i));
            if(twoDig>=10 && twoDig<=26)
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}
