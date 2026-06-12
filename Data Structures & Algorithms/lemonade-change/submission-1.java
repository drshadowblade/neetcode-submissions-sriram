class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] arr=new int[3];
        if(bills[0]!=5) return false;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5) arr[0]++;
            if(bills[i]==10)
            {
                if(arr[0]>0)
                {
                    arr[1]++;
                    arr[0]--;
                }
                else return false;
            }
            if(bills[i]==20)
            {
                if((arr[1]>0 && arr[0]>0) || arr[0]>=3)
                {
                    if(arr[1]!=0)
                    {
                        arr[1]--;
                        arr[0]--;
                    }
                    else
                        arr[0]-=3;
                }
                else
                    return false;
            }
        }
        return true;
    }
}