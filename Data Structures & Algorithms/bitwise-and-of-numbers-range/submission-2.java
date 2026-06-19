class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int and=left;
        while(left<=right){
            and=and & left;
            left++;
            if(left<0) break;
            if(and==0) return and;
        }
        return and;
    }
}