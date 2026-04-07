class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for(int[] p:points)
        {
            q.add(p);
            if(q.size()>k)
                q.poll();
        }
        
        int[][] res=new int[k][2];
        int idx=0;
        while(!q.isEmpty())
        {
            res[idx++]=q.poll();
        }
        return res;
    }
}
