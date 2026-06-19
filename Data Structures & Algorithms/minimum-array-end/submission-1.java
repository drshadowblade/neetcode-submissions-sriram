class Solution {
    public long minEnd(int n, int x) {
        int i=1;
        long num=x;
        while(i<n)
        {
            num = (num+1) | x;
            i++;
        }
        return num;
    }
}