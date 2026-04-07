class KthLargest {
    PriorityQueue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        q=new PriorityQueue<>();
        for(int num:nums)
            add(num);
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size()>k)
            q.poll();
        return q.peek();
    }
}
