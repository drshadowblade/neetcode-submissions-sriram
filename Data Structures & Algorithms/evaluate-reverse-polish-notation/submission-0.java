class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> result=new Stack<>();
        for(String str:tokens)
        {
            if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*"))
            {
                int a=result.pop();
                int b=result.pop();
                int c=0;
                switch(str)
                {
                    case "+": 
                        c=b+a;
                        break;
                    case "-": 
                        c=b-a;
                        break;
                    case "*": 
                        c=b*a;
                        break;
                    case "/": 
                        c=b/a;
                        break;
                }

                result.push(c);
            }
            else
                result.push(Integer.parseInt(str));
        }
        return result.pop();
    }
}
