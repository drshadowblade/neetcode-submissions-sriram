class Solution {
    public String decodeString(String s) {
        Stack<Integer> number=new Stack<>();
        Stack<String> string=new Stack<>();
        int num=0;
        String curr="";
        for(char c:s.toCharArray())
        {
            if(Character.isDigit(c))
                num=num*10+(c-'0');
            else if(c=='[')
            {
                number.push(num);
                string.push(curr);
                curr="";
                num=0;
            }
            else if(c==']')
            {
                int loop=number.pop();
                StringBuilder sb=new StringBuilder(string.pop());
                for(int i=0;i<loop;i++)
                {
                    sb.append(curr);
                }
                curr=sb.toString();
            }
            else
                curr+=c;
        }
        return curr;
    }
}