class Solution {
    public boolean checkValidString(String s) {
        int lmin=0,lmax=0;
        for(char c:s.toCharArray())
        {
            if(c=='('){
                lmin++;lmax++;}
            else if(c==')'){
                lmin--;lmax--;}
            else{
                lmin--;lmax++;}
            if(lmax<0) return false;
            if(lmin<0) lmin=0;
        }
        return lmin==0;
    }
}
