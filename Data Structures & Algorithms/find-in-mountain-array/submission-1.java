/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();

        int peak=getPeak(mountainArr,n);

        int left=getIndex(mountainArr,target,0,peak,true);
        if(left!=-1) return left;

        return getIndex(mountainArr,target,peak+1,n-1,false);
    }

    private int getPeak(MountainArray arr,int n)
    {
        int left=0;
        int right=n-1;
        while(left<right)
        {
            int mid=(right+left)/2;

            if(arr.get(mid)<arr.get(mid+1))
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }

    private int getIndex(MountainArray arr,int target,int start,int end,boolean asc)
    {
        int left=start;
        int right=end;

        while(left<=right)
        {
            int mid=(right+left)/2;
            int value=arr.get(mid);
            if(value==target)
                return mid;
            if(asc)
            {
                if(value<target)
                {
                    left=mid+1;
                }
                else
                    right=mid-1;
            }
            else
            {
                if(value<target)
                {
                    right=mid-1;
                }
                else
                    left=mid+1;
            }
        }
        return -1;

    }

}