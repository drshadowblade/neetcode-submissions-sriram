class Solution {
    private void reverse(int[] arr)
    {
        int left=0;
        int right=arr.length-1;
        while(left<=right)
        {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4) return false;
        int total=0;
        for(int num:matchsticks)
            total+=num;
        if(total%4!=0) return false;
        int side=total/4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides=new int[4];
        return backtrack(matchsticks,sides,0,side);
    }
    private boolean backtrack(int[] sticks,int[] sides,int index,int side)
    {
        if(index==sticks.length)
            return true;
        
        for(int i=0;i<4;i++)
        {
            if(sides[i]+sticks[index]<=side)
            {
                sides[i]+=sticks[index];
                if(backtrack(sticks,sides,index+1,side))
                    return true;
                sides[i]-=sticks[index];
            }
        }
        return false;
    }
}