class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,tank=0,start=0;
        for(int i=0;i<gas.length;i++)
        {
            total+=(gas[i]-cost[i]);
            tank+=(gas[i]-cost[i]);
            if(tank<0)
            {
                tank=0;
                start=i+1;
            }
        }
        if(total>=0) return start;
        return -1;
    }
}
