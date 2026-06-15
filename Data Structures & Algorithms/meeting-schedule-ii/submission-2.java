/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals==null || intervals.size()==0) return 0;
        if(intervals.size()==1) return 1;
        int n=intervals.size();
        int[] start=new int[n];
        int[] end=new int[n];
        int idx=0;
        for(Interval i:intervals)
        {
            start[idx]=i.start;
            end[idx]=i.end;
            idx++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s=0,e=0;
        int max=0,count=0;
        while(s<n)
        {
            if(start[s]<end[e])
            {
                s++;
                count++;
            }
            else
            {
                e++;
                count--;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
