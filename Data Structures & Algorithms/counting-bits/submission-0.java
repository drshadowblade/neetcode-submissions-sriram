class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            int count=0;
            int num=i;
            while(num>0)
            {
                if((num & 1)==1) count++;
                num = num>>>1;
            }
            res[i]=count;
        }
        return res;
    }
}
