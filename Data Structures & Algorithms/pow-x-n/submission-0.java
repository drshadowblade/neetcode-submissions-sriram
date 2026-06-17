class Solution {
    public double myPow(double x, int n) {
        if(n<0) return 1/myPow(x,-(n));
        return n==1 ? x : x*myPow(x,n-1);
    }
}
