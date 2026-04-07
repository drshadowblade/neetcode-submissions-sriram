class Solution {
    public int maxProfit(int[] prices) {
        int left=0;
        int n=prices.length;
        int maxProf=0;
        int right=1;
        while(right<n)
        {
            if(prices[left]<prices[right])
            {
                int prof=prices[right]-prices[left];
                maxProf=Math.max(prof,maxProf);
            }
            else
                left=right;
            right++;
        }
        return maxProf;
    }
}
