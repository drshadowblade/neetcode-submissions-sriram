class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash=new HashSet<>();
        int maxlength=0;
        for(int num:nums)
        {
            hash.add(num);
        }

        for(int num:nums)
        {
            int currentNum=num;
            int length=1;
            if(!hash.contains(num-1))
            {
                while(hash.contains(currentNum+1))
                {
                    currentNum++;
                    length++;
                }
            }
            if(length>maxlength)
                maxlength=length;
        }
        return maxlength;
    }
}
