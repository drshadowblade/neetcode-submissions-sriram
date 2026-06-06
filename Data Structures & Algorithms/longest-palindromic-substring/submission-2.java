class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String result="";
        int maxlen=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                if(isPalindrome(s,i,j) && j-i+1>maxlen)
                {
                    maxlen=j-i+1;
                    result=s.substring(i,j+1);
                }
            }
        }
        return result;
    }
    public boolean isPalindrome(String s,int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
