class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int area=0,maxArea=0;
        while(left<right)
        {
            int length=right-left;
            int width=Math.min(heights[right],heights[left]);
            area=length*width;
            if(area>maxArea)
            {
                maxArea=area;
            }
            if(heights[left]<heights[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
