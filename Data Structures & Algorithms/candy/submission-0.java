class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] cost=new int[n];
        Arrays.fill(cost,1);
        for(int i=0;i<n-1;i++)
        {
            if(ratings[i]<ratings[i+1])
            {
                cost[i+1]=cost[i]+1;
            }
        }
        int sum=0;
        for(int i=n-1;i>=1;i--)
        {
            if(ratings[i]<ratings[i-1])
            {
                cost[i-1]=Math.max(cost[i-1],cost[i]+1);
            }
        }
        for(int num:cost)
            sum+=num;
        return sum;
    }
}