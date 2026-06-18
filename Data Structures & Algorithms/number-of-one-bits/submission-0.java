class Solution {
    public int hammingWeight(int n) {
        int i=0;
        int count=0;
        while(i<32)
        {
            if( (n & 1) != 0)
                count++;
            n= n>>>1;
            i++;
        }
        return count;
    }
}
