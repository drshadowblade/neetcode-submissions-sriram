class Solution {
    public int maxTurbulenceSize(int[] arr) {
        char prev='=';
        int r=1;
        int l=0;
        int n=arr.length;
        int res=1;
        while(r<n)
        {
            if(arr[r-1]<arr[r] && prev!='<')
            {
                res=Math.max(res,r-l+1);
                prev='<';
                r++;
            }
            else if(arr[r-1]>arr[r] && prev!='>')
            {
                res=Math.max(res,r-l+1);
                prev='>';
                r++;
            }
            else
            {
                if(arr[r-1]==arr[r])
                    r=r+1;
                l=r-1;
                prev='=';
            }
        }
        return res;
    }
}