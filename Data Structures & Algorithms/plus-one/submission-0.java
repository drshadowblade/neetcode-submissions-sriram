class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--)
        {
            int sum=digits[i]+carry;
            if(sum>9) 
            {
                carry=sum/10;
                digits[i]=sum%10;
            }
            else
            {
                digits[i]=sum;
                carry=0;
                break;
            }
        }
        if(carry==1)
        {
            int[] res=new int[digits.length+1];
            res[0]=carry;
            for(int i=0;i<digits.length;i++)
            {
                res[i+1]=digits[i];
            }
            return res;
        }
        return digits;
    }
}
