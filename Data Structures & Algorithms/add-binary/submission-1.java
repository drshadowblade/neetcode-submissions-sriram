class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) return addBinary(b,a);
        StringBuilder sb=new StringBuilder();
        int n=b.length();
        int m=a.length()-1;
        int carry=0;
        for(int i=n-1;i>=0;i--)
        {
            int num1=a.charAt(m)-'0';
            int num2=b.charAt(i)-'0';
            int sum=num1+num2+carry;
            carry=sum/2;
            sb.append(sum%2);
            m--;
        }
        while(m>=0)
        {
            int num1=a.charAt(m)-'0';
            int sum=num1+carry;
            carry=sum/2;
            sb.append(sum%2);
            m--;
        }
        if(carry>0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}