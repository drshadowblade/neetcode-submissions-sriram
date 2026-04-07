class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int area=0,maxarea=0;
        while(left<right)
        {
            int height=right-left;
            int width=Math.min(heights[left],heights[right]);
            area=width*height;
            if(area>maxarea)
                maxarea=area;
            if(heights[left]<heights[right])
                left++;
            else
                right--;
        }
        return maxarea;
    }
}
