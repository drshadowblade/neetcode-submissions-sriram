class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int n=b.length()-1;
        int m=a.length()-1;
        int carry=0;
        while(n>=0 || m>=0 || carry>0)
        {
            int sum=0;
            if(n>=0)
            {
                sum+=(b.charAt(n)-'0');
                n--;
            }
            if(m>=0)
            {
                sum+=(a.charAt(m)-'0');
                m--;
            }
            sum+=carry;
            carry=sum/2;
            sb.append(sum%2);
        }
        return sb.reverse().toString();
    }
}