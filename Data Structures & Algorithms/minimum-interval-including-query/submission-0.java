class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] quer=Arrays.stream(queries).sorted().toArray();
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] result=new int[queries.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])
                return Integer.compare(a[0],b[0]);
            else
                return Integer.compare(a[1],b[1]);
        });
        int i=0;
        for(int q:quer)
        {
            while(i<intervals.length && intervals[i][0]<=q)
            {
                int l=intervals[i][0];
                int r=intervals[i][1];
                pq.offer(new int[]{r-l+1,r});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<q)
                pq.poll();
            if(!pq.isEmpty())
                map.put(q,pq.peek()[0]);
            else
                map.put(q,-1);
        }
        int idx=0;
        for(int q:queries)
        {
            result[idx++]=map.get(q);
        }
        return result;
    }
}
