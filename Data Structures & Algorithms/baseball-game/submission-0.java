class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();

        for(String str:operations)
        {
            if(str.equals("+"))
            {
                int last=st.pop();
                int secondlast=st.peek();
                int temp=last+secondlast;
                st.push(last);
                st.push(temp);
            }
            else if(str.equals("C"))
                st.pop();
            else if(str.equals("D"))
                st.push(st.peek()*2);
            else
                st.push(Integer.parseInt(str));
        }
        int total=0;
        for(int num:st)
            total+=num;
        return total;
    }
}