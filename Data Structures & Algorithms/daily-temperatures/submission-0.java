class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp=new Stack<>();
        int n=temperatures.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!temp.isEmpty() && temperatures[i]>temperatures[temp.peek()])
            {
                int prev=temp.pop();
                result[prev]=i-prev;
            }
            temp.push(i);
        }
        return result;
    }
}
