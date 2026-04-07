class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[i]<heights[st.peek()])
            {
                int top=st.pop();
                int height=heights[top];
                int width= st.isEmpty() ? i:i-st.peek()-1;
                int area=height*width;

                maxArea=Math.max(area,maxArea);
            }
            st.push(i);
        }
        int i=n;
        while(!st.isEmpty())
        {
            int top=st.pop();
            int height=heights[top];
            int width= st.isEmpty() ? i:i-st.peek()-1;
            int area=height*width;

            maxArea=Math.max(area,maxArea);
        }

        return maxArea;
    }
}
