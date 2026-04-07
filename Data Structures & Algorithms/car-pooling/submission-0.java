class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int diff[]=new int[1001];

        for(int[] trip:trips)
        {
            int num=trip[0];
            int from=trip[1];
            int to=trip[2];

            diff[from]+=num;
            diff[to]-=num;
        }
        int curr=0;
        for(int i=0;i<1001;i++)
        {
            if(curr>capacity)
                return false;
            curr+=diff[i];
        }
        return true;
    }
}