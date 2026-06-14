class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean one=false;
        boolean two=false;
        boolean three=false;
        for(int i=0;i<triplets.length;i++)
        {
            int[] t=triplets[i];
            if(t[0]>target[0] || t[1]>target[1] || t[2]>target[2]) continue;
            if(t[0]==target[0]) one=true;
            if(t[1]==target[1]) two=true;
            if(t[2]==target[2]) three=true;
        }
        return one && two && three;
    }
}
