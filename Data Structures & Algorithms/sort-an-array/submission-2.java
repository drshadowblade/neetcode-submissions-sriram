/*
class Solution {
    public int[] sortArray(int[] nums) {
        List<Integer> arrayList = new ArrayList<>();
        for (int num : nums) arrayList.add(num);
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            int key=arrayList.get(i);
            int beg=0;
            int end=i-1;
            int idx;
            while(beg<=end)
            {
                int mid=(beg+end)/2;
                if(arrayList.get(mid)>key)
                    end=mid-1;
                else
                    beg=mid+1;
            }
            idx=beg;
            arrayList.remove(i);
            arrayList.add(idx,key);
        }
        int[] result=new int[arrayList.size()];
        for(int i=0;i<n;i++)
        {
            result[i]=arrayList.get(i);
        }
        return result;
    }
}
*/
/*
class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int n:nums)
            p.add(n);
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=p.poll();
        }
        return arr;
    }
}
*/
class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        for(int i=n/2-1;i>=0;i--)
            heapify(nums,n,i);
        for(int i=n-1;i>0;i--)
        {
            int temp=nums[i];
            nums[i]=nums[0];
            nums[0]=temp;
            heapify(nums,i,0);
        }
        return nums;
    }
    public void heapify(int nums[],int n,int i)
    {
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && nums[left]>nums[largest])
            largest=left;
        if(right<n && nums[right]>nums[largest])
            largest=right;

        if(largest!=i)
        {
            int temp=nums[i];
            nums[i]=nums[largest];
            nums[largest]=temp;
            heapify(nums,n,largest);
        }
    }
}