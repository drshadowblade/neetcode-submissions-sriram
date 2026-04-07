class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int right=0;
        int left=0;
        for(int w:weights)
        {
            left=Math.max(w,left);
            right+=w;
        }
       
        while(left<right)
        {
            int mid=left+(right-left)/2;
            int requiredDays=1;
            int currLoad=0;
            for(int w:weights)
            {
                if(currLoad+w>mid)
                {
                    requiredDays++;
                    currLoad=0;
                }
                currLoad+=w;
            }
            if(requiredDays<=days)
            {
                right=mid;
            }
            else
                left=mid+1;
        }
        return left;
    }
}