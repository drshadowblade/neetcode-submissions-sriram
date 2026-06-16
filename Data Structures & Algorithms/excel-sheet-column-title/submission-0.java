class Solution {
    public String convertToTitle(int columnNumber) {
        String res="";
        while(columnNumber>0)
        {
            columnNumber--;
            char c=(char)('A'+columnNumber%26);
            res+=c;
            columnNumber/=26;
        }
        StringBuilder sb=new StringBuilder(res);
        return sb.reverse().toString();
    }
}